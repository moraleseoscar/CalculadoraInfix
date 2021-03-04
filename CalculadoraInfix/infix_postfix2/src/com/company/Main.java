package com.company;

public class Main {

    public static void main(String[] args) {
        //Colocar en String exp
        //la expresion a evaluar
        //del archivo de texto
        String exp = "(1+2)*9";
        System.out.println(ValorMayorF.infix_postfix(exp));
    }
}

/*Codigo de referencia tomado de GeeksforGeeks
Modificado por Marcelo Calderon y Oscar Estrada
 */
