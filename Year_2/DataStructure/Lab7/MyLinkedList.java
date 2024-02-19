package Lab7;

public class MyLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }
    Node head = null;

    public int getAt(int i) {
        Node p = head;
        while (i > 0) {
            p = p.next;
            i -= 1;
        }
        return (p.data);
    }

    public void setAt(int d, int i) {
        Node p = head;
        while (i > 0) {
            p = p.next;
            i -= 1;
        }
        p.data = d;
    }

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d, Node p) {
        Node q = new Node(d);
        q.next = p.next;
        p.next = q;
    }

    public void delete(int d) {
        Node t = new Node(d + 1);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next; 
    }

    public Node find(int d) {
        Node p = head;
        while (p != null) {
            if (p.data == d)
                return (p);
            p = p.next;
        }
        return (null);
    }

     public String toString() {
        StringBuffer sb = new StringBuffer("head");
        Node p = head;
        while (p != null) {
            sb.append("-> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return (new String(sb));
     }
}
