package Lab5;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputeRPN {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String rpn = in.nextLine();
        StringTokenizer st = new StringTokenizer(rpn);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            System.out.println(t + " is a number? -> " + isNumeric(t));
        }
        System.out.println(calculation(rpn));
        in.close();
    }

    public static double calculation(String rpn) {
        MyStackL stack = new MyStackL();
        StringTokenizer st = new StringTokenizer(rpn);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();

            if (isNumeric(t)) {
                stack.push(Double.parseDouble(t));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double fusion = Integer.MIN_VALUE;

                switch (t) {
                    case "+":
                        fusion = num2 + num1;
                        break;
                    case "-":
                        fusion = num2 - num1;
                        break;
                    case "*":
                        fusion = num2 * num1;
                        break;
                    case "/":
                        if (num1 != 0)
                            fusion = num2 / num1;
                        else
                            System.out.println("Not dividable");
                        break;
                    case "^":
                        fusion = Math.pow(num2, num1);
                        break;

                    default:
                        System.out.println("Not an Operator");
                        break;
                }

                stack.push(fusion);
            }
        }
        return stack.pop();

    }
}