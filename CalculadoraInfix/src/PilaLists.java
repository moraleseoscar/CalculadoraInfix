import java.util.LinkedList;

/**
 * @author Oscar Estrada y Marcelo Calderon
 *
 */
public class PilaLists<E> extends StackPila implements IList {
	private LinkedList<E> lista = new LinkedList<E>();
	private double operandoA;
	private double operandoB;
	
	/** 
	 * @param item
	 * Inserta un objeto E dentro del Stack
	 */
	@Override
	public void push(String item) {
		// TODO Auto-generated method stub
		lista.addFirst((E) item);
	}

	
	/** 
	 * @return String
	 * Elimina y devuelve la variable que se encuentra en el top del Stack
	 */
	@Override
	public String pop() {
		// TODO Auto-generated method stub
		String value = peek();
		lista.removeFirst();
		return value;
	}

	
	/** 
	 * @return String
	 * Devuelve la variable que se encuentre en el top del Stack
	 */
	@Override
	public String peek() {
		// TODO Auto-generated method stub
		return (String) lista.getFirst();
	}

	
	/** 
	 * @return boolean
	 * Devuelve un valor booleano para reconocer si la pila se encuentra vacia o no
	 */
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return lista.isEmpty();
	}

	
	/** 
	 * @return int
	 * Devuelve el tamano de la pila
	 */
	@Override
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
	@Override
	public Double resolver(String input) {
		// TODO Auto-generated method stub
		Double resultado = 0.0;
		input = input.replaceAll(" ","");
		for(String ch: input.split("")) {
			try {
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
				case "/":
					operandoA = Double.parseDouble(pop());
					operandoB = Double.parseDouble(pop());
					if(operandoB == 0) {
						resultado = 0.0;
					}
					resultado = operandoA / operandoB;
					push(resultado.toString());
					break;
				default:
					try {
						Double test = Double.parseDouble(ch);
						push(ch);
					}catch(Exception e) {}
				}
			}catch(Exception NoSuchElementException) {}
		}
		return resultado;
	}
}
