package loja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class CarrinhoDeCompras {

	private List<Produto> produtos;

	public CarrinhoDeCompras() {
		this.produtos = new ArrayList<Produto>();
	}

	public void adicionarAoCarrinho(Produto produto) {
		produtos.add(produto);
	}

	public double getValorTotal() {
		double total = 0.0;
		for (Produto p : produtos) {
			total += p.getValor();
		}
		return total;
	}
	
	public List<Produto> getProdutosPorPreco(){
		Collections.sort(produtos, new ComparadorDeProdutosPorPrecoAsc());
		return produtos;
	}
	
	public List<Produto> getProdutosPorNome(){
		Collections.sort(produtos, new ComparadorDeProdutosPorNomeAsc());
		return produtos;
	}

	public static void main(String[] args) {
		Filme f = new Filme("Lord of RIngs", 1.99, "Obviamente o melhor filme de todos");

		Comida c = new Comida("Empadinha", 1.00, "Muito boa");
		
		Equipamento e = new Equipamento("Processador", 250.00, "I7 8th"); 
		
		CarrinhoDeCompras ca = new CarrinhoDeCompras();
		ca.adicionarAoCarrinho(f);
		ca.adicionarAoCarrinho(c);
		ca.adicionarAoCarrinho(e);
		
		for (Produto p : ca.getProdutosPorNome()) {
			System.out.println(p.getNome() + " - R$ " + p.getValor());
		}
		
		System.out.println("O valor total é R$ " + ca.getValorTotal());
	}

}
