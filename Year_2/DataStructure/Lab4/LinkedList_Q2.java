package Lab4;

public class LinkedList_Q2 {
    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();   

        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i : data)
            mList.add(i);

        mList.head = reverse(mList);
        mList.head = deleteByRange(mList, 3, 2);
        System.out.println(mList);
        
    }

    public static MyLinkedList.Node deleteByRange(MyLinkedList mList, int i, int r) {
        MyLinkedList.Node   head = mList.head;
        MyLinkedList.Node   temp = head;
        MyLinkedList.Node   tail;
        
        for (int index = 1; index < i; index++) {
            head = head.next;
        }

        tail = head;
        for (int index = 0; index < r + 1; index++)
            tail = tail.next;
        head.next = tail;

        return (temp);
    }

    public static MyLinkedList.Node reverse(MyLinkedList mList) {
        MyLinkedList.Node   temp;    
        MyLinkedList.Node   current;
        MyLinkedList.Node   prev;

        current = mList.head;
        prev = null;
        temp = current;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return (prev);
    }
}

