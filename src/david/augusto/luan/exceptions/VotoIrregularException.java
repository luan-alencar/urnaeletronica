package david.augusto.luan.exceptions;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

public class VotoIrregularException extends Exception {

	private static final long serialVersionUID = 1L;

	public VotoIrregularException() {
		super("O eleitor não pode votar");
	}
}
