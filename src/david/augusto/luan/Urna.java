package david.augusto.luan;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.exceptions.VotoIrregularException;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Urna {

	private List<Eleitor> eleitores;
	private List<Candidato> candidatos;
	private int votosNulos;

	public Urna() {
		this.eleitores = new ArrayList<>();
		this.candidatos = new ArrayList<>();
		this.votosNulos = 0;
	}

	public void cadastrarEleitor(Eleitor eleitor) {
		eleitores.add(eleitor);
	}

	public void cadastrarCandidato(Candidato candidato) {
		candidatos.add(candidato);
	}

	public boolean podeVotar(String tituloEleitor) {
		Eleitor e = getEleitor(tituloEleitor);

		if (e != null) {
			// so vai retornar true se o cara existir e se ainda não votou
			if (!e.isJaVotou()) {
				return true;
			}
		}
		return false;
	}

	public void votar(String tituloEleitor, int numeroCandidato) throws VotoIrregularException {
		if (podeVotar(tituloEleitor)) {
			Candidato c = getCandidato(numeroCandidato);
			if (c != null) {
				c.votar();
			} else {
				votarNulo();
			}
			Eleitor e = getEleitor(tituloEleitor);
			e.votar();
		} else {
			throw new VotoIrregularException();
		}
	}

	private Eleitor getEleitor(String tituloEleitor) {
		Eleitor eleitor = null;
		for (Eleitor e : eleitores) {
			if (e.getTitulo().equals(tituloEleitor)) {
				eleitor = e;
			}
		}
		return eleitor;
	}

	private void votarNulo() {
		votosNulos++;
	}

	private Candidato getCandidato(int numeroCandidato) {
		Candidato candidato = null;
		for (Candidato c : candidatos) {
			if (c.getNumero() == numeroCandidato) {
				candidato = c;
			}
		}
		return candidato;
	}

	public Candidato getVencedor() {
		int maxVotos = 0;
		Candidato candidatoVencedor = null;
		for (Candidato c : candidatos) {
			if (c.getVotos() > maxVotos) {
				maxVotos = c.getVotos();
				candidatoVencedor = c;
			}
		}
		return candidatoVencedor;
	}

	public void exibirApuracao() {
		for (Candidato c : candidatos) {
			System.out.println("\n" + c.getNome() + " - Votos: "+ c.getVotos());
		}
	}

	public static void main(String[] args) {
		Urna u = new Urna();

		Candidato c1 = new Candidato(15, "Jemao");
		Candidato c2 = new Candidato(25, "Bruno Catao");
		Candidato c3 = new Candidato(50, "Lizianne");

		// cadastrando cadidatos
		u.cadastrarCandidato(c1);
		u.cadastrarCandidato(c2);
		u.cadastrarCandidato(c3);

		Eleitor e1 = new Eleitor("1234", "Luan");
		Eleitor e2 = new Eleitor("4321", "Laissa");
		Eleitor e3 = new Eleitor("12522", "Vitoria");
		Eleitor e4 = new Eleitor("295823", "Ysla");
		Eleitor e5 = new Eleitor("8393", "Alessandro");
		Eleitor e6 = new Eleitor("6532", "Thiago");
		Eleitor e7 = new Eleitor("687662", "Giselly");

		// cadastrando eleitores
		u.cadastrarEleitor(e1);
		u.cadastrarEleitor(e2);
		u.cadastrarEleitor(e3);
		u.cadastrarEleitor(e4);
		u.cadastrarEleitor(e5);
		u.cadastrarEleitor(e6);
		u.cadastrarEleitor(e7);

		// votação
		extracaoDaVotacao(u);
		
		// Apuração da eleição
		u.exibirApuracao();
		
		// Mostrando vencedor
		Candidato vencedor = u.getVencedor();
		System.out.println("Quem venceu a eleição foi o candidato: " + vencedor);

	}

	private static void extracaoDaVotacao(Urna u) {
		try {
			u.votar("4321", 15);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("12522", 15);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("295823", 25);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("295823", 15);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("8393", 15);
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("6532", 15);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("6532", 50);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}

		try {
			u.votar("687662", 50);
			System.out.println("Voto realizado com sucesso!");
		} catch (VotoIrregularException e) {
			System.err.println("Voto irregular");
		}
	}

}
