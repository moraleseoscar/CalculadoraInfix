/**
 * @author Oscar Estrada 
 *
 */
public class Fabrica {
	
	public Stack tipoPila(int tipo) {
		
		Stack tipoPila = null;
		
		if(tipo == 1) {
			return  new PilaArrays();
		}else if (tipo == 2){
			return  new PilaVectores();
		}else if (tipo == 3) {
			return  new PilaArrays();
		}else return null;

	}
}
