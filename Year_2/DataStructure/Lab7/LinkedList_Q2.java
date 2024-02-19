package Lab7;

public class LinkedList_Q2 {
    static MyLinkedList mList = new MyLinkedList();
    
        public static void main(String[] args) {
            int[] data = {43, 41, 21, 21, 12, 12, 11};
            
            for (int i = 0; i < data.length; i++)
                mList.add(data[i]);
            System.out.println(mList);
            System.out.println(removeDup(mList));
        }
    
        static MyLinkedList removeDup(MyLinkedList list) {
            MyLinkedList.Node cur = list.head;
    
            while (cur != null) {
                while (cur.next != null && cur.next.data == cur.data)
                    cur.next = cur.next.next;
                cur = cur.next;
            }
            return (list);
        }
}
