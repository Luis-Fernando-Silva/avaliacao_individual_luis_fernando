package br.org.serratec.avaliacaoIndividual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.avaliacaoIndividual.dto.PedidoDto;
import br.org.serratec.avaliacaoIndividual.model.Pedido;
import br.org.serratec.avaliacaoIndividual.repository.PedidoRepositorio;


@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepositorio pedidoRepositorio;
	
	public PedidoDto adicionarPedido(PedidoDto pedido) {
		Pedido pedidoEntity = pedidoRepositorio.save(pedido.toEntity());
		return pedidoEntity.toDto();
	}
	
	public Optional<PedidoDto> listarPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepositorio.findById(id);
		if(pedido.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(pedido.get().toDto());
	}
	
	public List<PedidoDto> listarTodos(){
		return pedidoRepositorio.findAll().stream()
				.map(t -> new PedidoDto(t.getId(), t.getNome(), t.getPedido(),
					 t.getPrato(), t.getValorPedido())).toList();
	}
	
	public Optional<PedidoDto> atualizarPedido(Long id, PedidoDto pedido){
		Pedido pedidoEntity = pedido.toEntity();
		if(pedidoRepositorio.existsById(id)) {
			pedidoEntity.setId(id);
			pedidoRepositorio.save(pedidoEntity);
			return Optional.of(pedidoEntity.toDto());
		}
		return Optional.empty();
	}
	
	public boolean excluirPedido(Long id) {
		if(!pedidoRepositorio.existsById(id)) {
			return false;
		}
		pedidoRepositorio.deleteById(id);
		return true;
	}
	
	public List<PedidoDto> listarNome(String nome) {
		return pedidoRepositorio.findByNomeContainingIgnoreCase(nome)
				.stream()
				.map(n -> new PedidoDto(n.getId(), n.getNome(), n.getPedido(),
					 n.getPrato(), n.getValorPedido())).toList();
		}
	
	public List<PedidoDto> listarPedido(String pedido) {
		return pedidoRepositorio.findByPedidoContainingIgnoreCase(pedido)
				.stream()
				.map(p -> new PedidoDto(p.getId(), p.getNome(), p.getPedido(),
					 p.getPrato(), p.getValorPedido())).toList();
		}
	
	public List<PedidoDto> listarPrato(String prato) {
		return pedidoRepositorio.findByPratoContainingIgnoreCase(prato)
				.stream()
				.map(p -> new PedidoDto(p.getId(), p.getNome(), p.getPedido(),
					 p.getPrato(), p.getValorPedido())).toList();
		}
}
