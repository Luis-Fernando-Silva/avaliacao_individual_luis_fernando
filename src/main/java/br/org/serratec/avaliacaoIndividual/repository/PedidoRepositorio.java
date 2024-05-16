package br.org.serratec.avaliacaoIndividual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.avaliacaoIndividual.model.Pedido;


public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{
	
	List<Pedido> findByNomeContainingIgnoreCase(String nome);
	List<Pedido> findByPedidoContainingIgnoreCase(String pedido);
	List<Pedido> findByPratoContainingIgnoreCase(String prato);

}
