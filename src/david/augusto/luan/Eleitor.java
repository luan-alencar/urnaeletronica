package david.augusto.luan;

import lombok.*;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

@Data
@Getter
@Setter
public class Eleitor {

	private String titulo;
	private String nome;
	private boolean jaVotou;

	public Eleitor(String titulo, String nome) {
		this.titulo = titulo;
		this.nome = nome;
	}

	public Eleitor() {
		this.jaVotou = false;
	}

	public void votar() {
		this.jaVotou = true;
	}

}
