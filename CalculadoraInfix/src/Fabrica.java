/**
 * @author Oscar Estrada y Marcelo Calderon
 *
 */
public class Fabrica {
	//Se crea la clase base para todo el programa
	//Es  el driver que le permite al usuario
	//interactuar con el programa.
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
