import java.util.Scanner;

/**
 * @author Oscar Estrada
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
		
		Stack pila = null;
		
		System.out.println("Seleccione el número de la acción que desea realizar: ");
		System.out.println("1. ArrayList");
		System.out.println("2. Vector");
		System.out.println("3. Listas");
        int sel = sc.nextInt();
        
        pila = fab.tipoPila(sel);
        
        
        String postfix = pila.leerDocumento();
        System.out.println("Resultado: " + pila.resolver(postfix));
        
	}

}
