import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * @author Oscar Estrada
 *
 */
public abstract class Stack implements IStack{
	protected double operandoA;
	protected double operandoB;
	
	/** 
	 * @return String
	 * Lee el documento insertado en la carpeta ./docs/datos.txt para que el documento que se actualice con ese nombre sea el procesado. Todo
	 * unicamente con el formato de postfix. A pesar que el programa evitara cualquier signo que no sea parte del formato, igual solo leera una
	 * linea.
	 */
	public String leerDocumento() {
		// TODO Auto-generated method stub
		String texto = new String();
		try {
			FileReader fr = new FileReader("./docs/datos.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;
			
			while((s = entrada.readLine()) != null) {
				texto = s;
			}
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
		return texto;
	}
	
}
