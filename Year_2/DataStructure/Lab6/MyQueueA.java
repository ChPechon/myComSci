package Lab6;

public class MyQueueA {
    int MAX_SIZE = 100;
    int queue[] = new int[MAX_SIZE];
    int head = 0, tail = 0;

    public void enqueue(int d) {
        queue[tail] = d;
        tail = (tail + 1) % MAX_SIZE;
    }

    public int dequeue() {
        int d = queue[head];
        head = (head + 1) % MAX_SIZE;
        return (d);
    }

    public int front() {
        return (queue[head]);
    }

    public boolean isFull() {
        return (((tail + 1) % MAX_SIZE) == head);
    }

    public boolean isEmpty() {
        return (head == tail);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tail; i++) {
            sb.append(String.format("│ %3d %3s\n", queue[i], "\u2502"));
        }
        sb.append("┴───────┴");
        return (sb.toString());
    }
}

