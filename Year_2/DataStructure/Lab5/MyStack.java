package Lab5;

public class MyStack {

    public class Node {
        double data;
        Node next;
        public Node(double d) {
            data = d;
        }
    }
    int size;
    Node top = null;

    public void push(double d) {
        Node p = new Node(d);
        p.next = top;
        top = p;
        size++;
    }

    public double pop() {
        double d = top.data;
        top = top.next;
        return (d);
    }

    public double top() {
        return (top.data);
    }

    public boolean isFull() {
        return (false);
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(size * 14);
        MyStack.Node revNode = top;
        
        while (revNode != null) {
            sb.append(String.format("│ %6.2f │\n", revNode.data));
            revNode = revNode.next;
        }

        sb.append("┴────────┴");
        return (sb.toString());
    }
}
