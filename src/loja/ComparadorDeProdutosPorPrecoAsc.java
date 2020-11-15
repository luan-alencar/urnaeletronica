package loja;

import java.util.Comparator;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

public class ComparadorDeProdutosPorPrecoAsc implements Comparator<Produto>{

	@Override
	public int compare(Produto p1, Produto p2) {
		if (p1.getValor() < p2.getValor()) {
			return -1;
		} else if(p1.getValor() > p2.getValor()) {
			return +1;
		}
		return 0;
	}

}
