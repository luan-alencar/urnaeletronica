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
public class Equipamento implements Produto {

	private String nome;
	private double preco;
	private String fichaTecnica;

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public double getValor() {
		return this.preco;
	}

}
