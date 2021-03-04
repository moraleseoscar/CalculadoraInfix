/**
 * @author Oscar Estrada 
 *
 */
public interface IStack{

	   public void push(String item);
	   // Post-condicion: El item se agrega a la pila
	   
	   public Object pop();
	   // Pre-condicion: Que la pila no se encuentre vacia
	   // Post-condicion: El item se remueve de la pila y la funci�n retorna dicho valor.

	   public Object peek();
	   // Pre-condicion: Que la pila no se encuentre vacia
	   // Post-condicion: Se devuelve el ultimo item que se encuentre en la pila (ultimo ingresado)
	   
	   public boolean empty();
	   // Post-condicion: Devuelve si la pila se enecuentra vacia o no (true/false)
	   
	   public int size();
	   // Post-condicion: Devuelve la cantidad de elementos dentro de la pila

	   public Double resolver(String input);
	   // Post-condicion: Devuelve la cantidad de elementos dentro de la pila

}
