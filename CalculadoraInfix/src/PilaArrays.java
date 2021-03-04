import java.util.ArrayList;

/**
 * @author Oscar Estrada y Marcelo Calderon
 *
 */
public class PilaArrays extends StackPila{
	private ArrayList<String> lista = new ArrayList<String>();
	
	/** 
	 * @param item
	 * Inserta un objeto dentro del Stack
	 */
	public void push(String item) {
		// TODO Auto-generated method stub
		lista.add(0, item);
	}
	
	/** 
	 * @return String
	 * Elimina y devuelve la variable que se encuentra en el top del Stack
	 */
	public String pop() {
		// TODO Auto-generated method stub
		String value = peek();
		lista.remove(0);
		return value;
	}
	
	/** 
	 * @return String
	 * Devuelve la variable que se encuentre en el top del Stack
	 */
	public String peek() {
		// TODO Auto-generated method stub
		return lista.get(0);
	}
	
	/** 
	 * @return boolean
	 * Devuelve un valor booleano para reconocer si la pila se encuentra vacia o no
	 */
	public boolean empty() {
		// TODO Auto-generated method stub
		return lista.isEmpty();
	}
	
	/** 
	 * @return int
	 * Devuelve el tamano de la pila
	 */
	public int size() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	
	/** 
	 * @param input
	 * @return Double
	 * Devuelve el procedimiento ya operado, siendo aca en donde se procesa cada dato del String obtenido al leer el documento.
	 * Excepciones utilizadas para casos presentados en el documento:
	 * 				---->Si el numero se divide entre 0, el resultado retornara 0.
	 * 				---->Si se inserta un caracter no permitido del formato postfix, este solo lo saltara.
	 * 				---->Si en un momento se intenta hacer una operacion con una cantidad de caracteres insuficientes
	 * 					 el programa solo saltara la operacion e imprimira hasta donde se haya quedado.
	 */
	public Double resolver(String input) {
		// TODO Auto-generated method stub
		Double resultado = 0.0;
		input = input.replaceAll(" ","");
		for(String ch: input.split("")) {
			try {
				//Condicional que analiza el operador
				//Suma, resta, multiplicacion, division, potencia
				switch(ch){
				case "+":
					operandoA = Double.parseDouble(pop());
					operandoB = Double.parseDouble(pop());
					resultado = operandoA + operandoB;
					push(resultado.toString());
					break;
				case "-":
					operandoA = Double.parseDouble(pop());
					operandoB = Double.parseDouble(pop());
					resultado = operandoA - operandoB;
					push(resultado.toString());
					break;
				case "*":
					operandoA = Double.parseDouble(pop());
					operandoB = Double.parseDouble(pop());
					resultado = operandoA * operandoB;
					push(resultado.toString());
					break;
				//Condicional de division
				case "/":
					operandoA = Double.parseDouble(pop());
					operandoB = Double.parseDouble(pop());
					//Condicional para verificar que no haya
					//una división inválida.
					if(operandoB == 0) {
						resultado = 0.0;
					}
					resultado = operandoA / operandoB;
					push(resultado.toString());
					break;
				//Funciion que recorre el String
				default:
					try {
						Double test = Double.parseDouble(ch);
						push(ch);
					}catch(Exception e) {}
				}
			}catch(Exception NoSuchElementException) {}
		}
		//Retorna la variable resultado
		return resultado;
	}
}
