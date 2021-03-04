package com.company;

import java.util.Stack;

public class ValorMayorF {

    static int VMF(char ch){

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
    static String infix_postfix(String exp){

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
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infix_postfix(exp));
    }

}
