package br.org.serratec.avaliacaoIndividual.dto;

import br.org.serratec.avaliacaoIndividual.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoDto (
		Long id,
		@NotBlank(message = "Por favor, insira um nome ao seu pedido!")
		String nome,
		@NotBlank(message = "Este campo não pode estar vazio.")
		String pedido,
		@NotBlank(message = "Informe o nome do prato escolhido!")
		String prato,
		@NotNull(message = "Insira um valor válido.")
		@Positive
		Double valorPedido) {
	
	public Pedido toEntity() {
		return new Pedido (this.id, this.nome, this.pedido, this.prato, this.valorPedido);
	}
}
