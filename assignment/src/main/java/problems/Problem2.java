package problems;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * evaluates arithmetic expressions given in polish notation
 */
public class Problem2 {
    /**
     * evaluates a stack of operands and operators
     * @param stack of operands and operators
     * @return String of result or error if invalid expression
     */
    public String evaluate(Stack<String> stack) {
        double tempDigit;
        String temp;
        Stack<Double> stack2 = new Stack<>();

        while (!stack.isEmpty()){
            temp = stack.pop();
            if("+-*/".contains(temp)){
                if(stack2.size() < 2){
                    return "error";
                }
                switch (temp){
                    case "+":
                        tempDigit = stack2.pop() + stack2.pop();
                        stack2.push(tempDigit);
                        break;
                    case "-":
                        tempDigit = stack2.pop() - stack2.pop();
                        stack2.push(tempDigit);
                        break;
                    case "/":
                        tempDigit = stack2.pop() / stack2.pop();
                        stack2.push(tempDigit);
                        break;
                    case "*":
                        tempDigit = stack2.pop() * stack2.pop();
                        stack2.push(tempDigit);
                        break;

                    default: break;

                }
            }
            else{
                stack2.push(Double.parseDouble(temp));
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if(stack2.size()>1){
            return "error";
        }
        return df.format(stack2.pop());

    }

    /**
     * Convert a string into a stack.
     * @param expr/expression of operators and operands, space separated
     * @return stack -''-
     */
    public Stack<String> make_stack(String expr) {
        String[] tokens = expr.split(" ");
        Stack<String> stack = new Stack<>();
        for(String i: tokens){
            stack.push(i);
        }
        return stack;
    }

    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        Scanner scn = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();

        while(scn.hasNextLine()){
            results.add(p2.evaluate(p2.make_stack(scn.nextLine())));
        }

        for(String s: results){
            System.out.println(s);
        }
    }
}
