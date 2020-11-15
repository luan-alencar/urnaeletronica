package david.augusto.luan.exceptions;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

public class CandidatoNaoExisteException extends Exception{

	private static final long serialVersionUID = 1L;

	public CandidatoNaoExisteException() {
		super("Operação não realizada, candidato não existe.");
	}
	
}
