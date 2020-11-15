package loja;

import java.util.Comparator;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

public class ComparadorDeProdutosPorNomeAsc  implements Comparator<Produto>{

	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getNome().compareTo(p2.getNome());
	}

}
