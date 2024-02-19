package Lab10a;

public class BST_Tester {
    public static void main(String[] args) {
        demo1();
    }

    static void demo1() {
        int[] data = {15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        BST bst = new BST();
        for (int i = 0; i < data.length; i++) {
            bst.insert(data[i]);
        }
        bst.printPreOrder();
        //8 10 12 15 16 18 19 20 25 30
        System.out.println();
        demo2(bst);
    }

    static void demo2(BST bst) {
        System.out.println("-more traversal---"); bst.printInOrder(); System.out.println();
        // 15 10 8 12 20 18 16 19 25 30
        bst.printPostOrder(); System.out.println();
        // 8 12 10 16 19 18 30 25 20 15
        demo3(bst);
    }

    static void demo3(BST bst) {
        System.out.println("-search recursive---"); 
        System.out.println(bst.search(20)); // 18<-20->25 
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(12)); // null<-12->null 
        System.out.println(bst.search(1)); // null 
        System.out.println(bst.searchRecurse(10 , bst.getRoot()));
        //if searchRecurse and getRoot is available
        System.out.println("-search iterative---"); System.out.println(bst.searchIter(20)); System.out.println(bst.searchIter(25)); System.out.println(bst.searchIter(12));
        System.out.println(bst.searchIter(1));
    }
}