package Lab3;

public class MyArray {
    int MAX_SIZE = 5;
    int data[] = new int[MAX_SIZE];
    int size = 0;

    public int add(int d) {
        if (isFull())
            return (-1);
        data[size++] = d;
        return (size);
    }

    public boolean isFull() {
        return (size == MAX_SIZE);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void insert(int d, int index) {
        for (int i = size; i > index; i--)
            data[i] = data[i - 1];
        data[index] = d;
        size++;
    }

    public int find(int d) {
        for (int i = 0; i < size; i++)
            if (data[i] == d)
                return (i);
        return (-1);
    }

    public void delete(int index) {
        for (int i = index; i < size; i++)
            data[i] = data[i + 1];
        size--;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(",");
        }
        if (size > 0)
            sb.append(data[size - 1]);
        sb.append("]");
        return (sb.toString());
    }
}
