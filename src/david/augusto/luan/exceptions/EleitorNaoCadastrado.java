package david.augusto.luan.exceptions;

/*
 * 
 * 	Aluno: Luan Augusto David de Alencar Lima
 * 
 * 
 */

public class EleitorNaoCadastrado extends Exception {

	private static final long serialVersionUID = 1L;

	public EleitorNaoCadastrado() {
		super("Operação não realizada, eleitor não existe");
	}
}
