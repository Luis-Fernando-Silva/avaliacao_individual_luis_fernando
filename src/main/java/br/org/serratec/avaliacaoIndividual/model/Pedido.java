package br.org.serratec.avaliacaoIndividual.model;

import br.org.serratec.avaliacaoIndividual.dto.PedidoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String pedido;
	private String prato;
	private Double valorPedido;
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, String nome, String pedido, String prato, Double valorPedido) {
		super();
		this.id = id;
		this.nome = nome;
		this.pedido = pedido;
		this.prato = prato;
		this.valorPedido = valorPedido;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getPrato() {
		return prato;
	}

	public void setPrato(String prato) {
		this.prato = prato;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	public PedidoDto toDto() {
		return new PedidoDto (this.id, this.nome, this.pedido, this.prato, this.valorPedido);
	}
}
