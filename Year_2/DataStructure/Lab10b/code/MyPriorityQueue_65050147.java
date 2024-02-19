package Lab10b.code;

public class MyPriorityQueue_65050147 implements MyQueueInterface{
    MyMinHeap heap = new MyMinHeap();
    public void enqueue(int d){
        if (!isFull())
            heap.insert(d);
    }
    public int dequeue(){
        if (!isEmpty())
            return (heap.remove());
        return (Integer.MIN_VALUE);
    }
    public int front(){
        return (heap.peek());
    }
    public boolean isFull(){
        return (heap.size >= 6);
    }
    public boolean isEmpty(){
        return (heap.isEmpty());
    }

    public String toString() {
        return (heap.toString());
    }
}
