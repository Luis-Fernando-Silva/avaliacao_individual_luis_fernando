package br.org.serratec.avaliacaoIndividual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.org.serratec.avaliacaoIndividual.dto.PedidoDto;
import br.org.serratec.avaliacaoIndividual.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService servico;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoDto cadastrarPedidos(@Valid @RequestBody PedidoDto pedido) {
		return servico.adicionarPedido(pedido);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> procurarPorId(@PathVariable Long id) {
		Optional<PedidoDto> pedido = servico.listarPorId(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> procurarTodos() {
		return ResponseEntity.ok(servico.listarTodos());
	}
	
	@GetMapping("/nome")
	public ResponseEntity<List<PedidoDto>> procurarPorNome(@RequestBody String nome) {
		return ResponseEntity.ok(servico.listarNome(nome));
	}
	
	@GetMapping("/pedido")
	public ResponseEntity<List<PedidoDto>> procurarPorPedido(@RequestBody String pedido) {
		return ResponseEntity.ok(servico.listarPedido(pedido));
	}
	
	@GetMapping("/prato")
	public ResponseEntity<List<PedidoDto>> procurarPorPrato(@RequestBody String prato) {
		return ResponseEntity.ok(servico.listarPrato(prato));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoDto> alterarPedidos(@PathVariable Long id, @RequestBody PedidoDto pedidoAlterado) {
		Optional<PedidoDto> pedido = servico.atualizarPedido(id, pedidoAlterado);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
		if(!servico.excluirPedido(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	
	
}
