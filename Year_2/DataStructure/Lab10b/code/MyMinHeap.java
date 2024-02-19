package Lab10b.code;

public class MyMinHeap {
    int MAX_SIZE = 100; 
    int heap[] = new int[MAX_SIZE]; 
    int size = 0; 
    
    public void insert(int d) {
        int p = size++; heap[p] = d; 
        int parent = (p - 1) / 2; 
        while((p > 0) && (heap[p] < heap[parent])) { 
            swap(p, parent); 
            p = parent; 
            parent = (p - 1) / 2;
        }
    } 
    
    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        int p = 0; 
        while(true)
        { 
            int left = 2 * p + 1; 
            if(left >= size) 
                break; // no child 
            int right = 2 * p + 2;
            if(right == size) { // one child 
                if(heap[p] > heap[left]) 
                    swap(p, left);
                break; // no more child, nothing to do
            } 
            else { // two childs 
                int q = heap[left] < heap[right] ? left : right; 
                if(heap[p] > heap[q]) 
                    swap(p, q);
                else 
                    break;
                p = q;
            }
            // ซ้าย < ขวา => left , แต่ไม่ ชี�ไป => ขวา }
        } // end while
        return (d);
    } 
    
    public int peek() {
        return (heap[0]);
    } 
    
    public boolean isFull() {
        return (heap.length == MAX_SIZE);
    } 
    
    public boolean isEmpty() {
        return (heap.length == 0);
    }

    public void swap(int p, int q) {
        int temp = heap[p];
        heap[p] = heap[q];
        heap[q] = temp;
    }
    
    public String toString() {
        String ret = "";
        int maxPerLine = 1;
        int[][] plain = new int[(int) Math.log(heap.length)][heap.length];
        for (int i = 0; i < plain.length; i++) {
            for (int j = 0; j < maxPerLine; j++) {
                plain[i][j] = heap[maxPerLine + j - 1];
            }
            maxPerLine *= 2;
        }
        maxPerLine = 2;
        ret += "\n";
        for (int i = 0; i < plain.length; i++) {
            for (int j = 0; j < plain.length; j++) {
                ret += (plain[i][j] != 0 ? plain[i][j] : "") + " ";
            }
            ret += "\n";
            if (i > plain.length - 3)
                continue;
            for (int j = 0; j < maxPerLine; j++) {
                if (j % 2 != 0) 
                    ret += "\\  ";
                else
                    ret += "|  ";
            }
            ret += "\n";
            maxPerLine *= 2;
        }
        return (ret);
    }
}