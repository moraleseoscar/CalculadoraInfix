/**
 * @author Oscar Estrada y Marcelo Calderon
 *
 */
public class Fabrica {
	
	public StackPila tipoPila(int tipo) {
		
		StackPila tipoPila = null;
		
		if(tipo == 1) {
			return  new PilaArrays();
		}else if (tipo == 2){
			return  new PilaVectores();
		}else if (tipo == 3) {
			return new PilaLists();
		}else return null;

	}
}
