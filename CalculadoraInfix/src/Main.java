import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oscar Estrada y Marcelo Calderon
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Fabrica fab = new Fabrica();
		//Se establece que el Stack toma un valor nulo
		//Esto es para iniciar el menu
		StackPila pila = null;
		boolean menu = true;
		//Muestra el menu en pantalla para que el usuario
		//seleccione la clase de programa a ejecutar
		while (menu) {
			System.out.println("");
			System.out.println("Tipos de pilas: \n------------------------");
			System.out.println("1. ArrayList");
			System.out.println("2. Vector");
			System.out.println("3. Listas");
			System.out.println("0. Salir");
			System.out.print("Seleccione el numero de la accion que desea realizar: ");
		//Scanner de la variable
	        int sel = sc.nextInt();
	        sc.nextLine();
		//Condicional para verificar que la variable
		//sel este dentro de los parametros
	        while(sel < 0 || sel > 3) {
	        	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
	            sel = sc.nextInt();
	            sc.nextLine();
			}
	        System.out.println("");
		//Apaga el menu
	        if(sel == 0) {
	        	menu = false;
		//Busca el metodo elegido para procesar
		//el stack
	        }else{
	        	pila = fab.tipoPila(sel);
		        
		        String postfix = pila.infix_postfix(pila.leerDocumento());
			//Retorna el resultado final
		        System.out.println("Resultado: " + pila.resolver(postfix));
	        }
		}
	}
}
