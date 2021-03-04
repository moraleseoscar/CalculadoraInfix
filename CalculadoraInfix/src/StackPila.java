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
//metodo para convertir de infix a postfix
    public String infix_postfix(String exp){

        String resultado = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i){

            char x = exp.charAt(i);

            if (Character.isLetterOrDigit(x))
                resultado += x;

            else if (x == '('){
                stack.push(x);
            }
            else if (x == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    resultado += stack.pop();
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && VMF(x) <= VMF(stack.peek())){

                    resultado += stack.pop();
                }
                stack.push(x);
            }

        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Expresion no valida.";
            resultado += stack.pop();
        }
        return resultado;
    }
	
}
