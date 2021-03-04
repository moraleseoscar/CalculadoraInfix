import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Oscar Estrada y Marcelo Calderon

 *
 */
public abstract class StackPila implements IStack{
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
	
	public int VMF(char ch){
	//Switch para detectar operador
	//Suma, resta, multiplicacion, division y potencia
        switch(ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
//Metodo para convertir de infix a postfix
    public String infix_postfix(String exp){
	//Creacion de la variable resultado
	//Creacion de stack principal
        String resultado = new String("");
        Stack<Character> stack = new Stack<>();
	//Funcion que recorre el string
        for (int i = 0; i<exp.length(); ++i){
	    //Variable que toma el valor posicional
            char x = exp.charAt(i);
	    
	    //Condicionales para analizar x
	    //Acomodan el valor de x de acuerdo al caso
		//Stacks
            if (Character.isLetterOrDigit(x))
                resultado += x;

	    //Condicionales para paréntesis
		//Caso de jerarquía de operaciones
            else if (x == '('){
                stack.push(x);
            }
            else if (x == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    resultado += stack.pop();
                stack.pop();
            }
	    //Caso de un operador
            else {
                while (!stack.isEmpty() && VMF(x) <= VMF(stack.peek())){

                    resultado += stack.pop();
                }
                stack.push(x);
            }

        }
	//Expulsa todos los caracteres del stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Expresion no valida.";
            resultado += stack.pop();
        }
        return resultado;
    }
	
}
