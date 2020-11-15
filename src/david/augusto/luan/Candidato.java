package david.augusto.luan;

import lombok.Data;
import lombok.Getter;
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
public class Candidato {

	private int numero;
	private int votos;
	private String nome;

	public Candidato(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
		this.votos = 0;
	}

	public Candidato() {
	}

	public void votar() {
		this.votos++;
	}
}
