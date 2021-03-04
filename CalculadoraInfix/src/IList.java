import java.util.Iterator;

/**
 * @author Oscar Estrada y Marcelo Calderon
 *
 */
public interface IList<E> {
	
	   public void push(String item);
	   // Post-condicion: El item se agrega a la pila
	   
	   public E pop();
	   // Pre-condicion: Que la pila no se encuentre vacia
	   // Post-condicion: El item se remueve de la pila y la funcion retorna dicho valor.

	   public E peek();
	   // Pre-condicion: Que la pila no se encuentre vacia
	   // Post-condicion: Se devuelve el ultimo item que se encuentre en la pila (ultimo ingresado)
	   
	   public boolean empty();
	   // Post-condicion: Devuelve si la pila se enecuentra vacia o no (true/false)
	   
	   public int size();
	   // Post-condicion: Devuelve la cantidad de elementos dentro de la pila

	   public Double resolver(String input);
	   // Pre-condicion: Solicita el string completo de todos los datos para hacer el calculo.
	   // Post-condicion: Devuelve el calculo resuelto segun la pila necesitada

}
