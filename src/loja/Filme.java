package loja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme implements Produto {

	private String titulo;
	private double valorAluguel;
	private String descricao;

	@Override
	public String getNome() {
		return this.titulo;
	}

	@Override
	public double getValor() {
		return this.valorAluguel;
	}

}
