package Lab7;

public class LinkedList_Q3 {
    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();
        int[] data = {5, 4, 3, 2, 1};

        for (int i = 0; i < data.length; i++)
            mList.add(data[i]);
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
