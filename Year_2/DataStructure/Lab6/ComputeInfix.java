package Lab6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeInfix {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return (false);
        return (pattern.matcher(strNum).matches());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input Infix: ");
        String Infix = in.nextLine();
        StringTokenizer st = new StringTokenizer(Infix);

        MyQueueL queue = new MyQueueL();
        MyStackOp stackOperator = new MyStackOp();
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t)) {
                queue.enqueue(t);
            } 
            else if(t.equals("+") || t.equals("-") ||
                     t.equals("*") || t.equals("/") || 
                     t.equals("^")) {
                while (!stackOperator.isEmpty() && !stackOperator.top().equals("(") &&
                        hasHigherPrecedence(stackOperator.top(), t)) {
                    queue.enqueue(stackOperator.pop());
                }
                stackOperator.push(t);
            }
            else if(t.equals("("))
                stackOperator.push(t);
            else if(t.equals(")")){
                while (!stackOperator.isEmpty() && !stackOperator.top().equals("("))
                    queue.enqueue(stackOperator.pop());
                stackOperator.pop();
            }
            else
                System.out.println("It's not operator");
        }

        while (!stackOperator.isEmpty())
            queue.enqueue(stackOperator.pop());
        // Print the postfix notation
        System.out.println("Postfix notation: " + queue);
        System.out.println(ComputeRPN(queue));
        in.close();
    }
    
    public static boolean hasHigherPrecedence(String op1, String op2) {
        int precedenceOp1 = getPrecedence(op1);
        int precedenceOp2 = getPrecedence(op2);
        return (precedenceOp1 >= precedenceOp2);
    }

    public static int getPrecedence(String operator) {
        switch (operator) {
            case "^" :
                return (3);
            case "*" :
            case "/" :
                return (2);
            case "+" :
            case "-" :
                return (1);
            default :
                return (0);
        }
    }

    public static double ComputeRPN(MyQueueL queue) {
        MyStackOp stack = new MyStackOp();
        ArrayList<String> st = new ArrayList<>();

        while (!queue.isEmpty())
            st.add(queue.dequeue());
        for (int i = 0; i < st.size(); i++) {
            String t = st.get(i);
            if (isNumeric(t))
                stack.push((t));
            else {
                if (t.equals("-")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a - b));
                } else if (t.equals("+")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a + b));
                } else if (t.equals("*")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(a * b));
                } else if (t.equals("/")) {
                    if (stack.top() == "0")
                        System.out.println("Not dividable");
                    else {
                        double b = Double.parseDouble(stack.pop());
                        double a = Double.parseDouble(stack.pop());
                        stack.push(Double.toString(a / b));
                    }
                } else if (t.equals("^")) {
                    double b = Double.parseDouble(stack.pop());
                    double a = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(Math.pow(a, b)));
                } else
                    System.out.println("Not an Operator");
            }
        }

        return (Double.parseDouble(stack.pop()));
    }
}
