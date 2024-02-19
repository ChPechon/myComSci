package Lab5;

public class MyStackA {
    int MAX_SIZE = 100;
    int stack[] = new int[MAX_SIZE];
    int top = 0;

    public void push(int d) {
        stack[top++] = d;
    }
    
    public int pop() {
        return (stack[--top]);
    }

    public int top() {
        return (stack[top - 1]);
    }

    public boolean isFull() {
        return (top == MAX_SIZE);
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(top * 14);
        for (int i = top - 1; i >= 0; i--) {
            sb.append(String.format("│ %6d │\n", stack[i]));
        }
        sb.append("┴────────┴");
        return (sb.toString());
    }
}
