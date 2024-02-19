package Lab5;

public class MyStackTester {
    public static void main(String[] args) {
        MyStackL stack = new MyStackL();
        stack.push(2000);
        stack.push(19);
        stack.push(18);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
