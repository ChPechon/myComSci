package Lab4;

public class LinkedList_Q5 {
    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();
        mList.add(4);
        mList.add(3);
        mList.add(2);
        mList.add(1);
        System.out.println(mList);
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
