package Lab4;

public class LinkedList_Q8 {
    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();   
        MyLinkedList.Node current;

        mList.add(9);        
        mList.add(9);
        mList.add(9);
        mList.add(9);
        mList.add(9);
        System.out.println(mList);
        mList.head = reverse(mList);
        
        current = mList.head;
        current.data += 1;
        while (current != null) {
            if (current.next == null && current.data == 10) {
                mList.add(1);
                current.data = 0;
                mList.head = reverse(mList);
            }

            if (current.next != null && current.data == 10) {
                current.data = 0;
                current.next.data += 1; 
            }
            current = current.next;
        }
        mList.head = reverse(mList);
        System.out.println(mList);
    }

    public static MyLinkedList.Node reverse(MyLinkedList mList) {
        MyLinkedList.Node temp;    
        MyLinkedList.Node current;
        MyLinkedList.Node prev;

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

