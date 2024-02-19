package Lab10a;

import Lab10a.code.TreeNode;

public class BST {
    private TreeNode root;

    public BST() {
        root = null;
    }

    public void  insert (int d) {
        if (root == null) 
            root = new TreeNode(d);
        else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.getData()) {
                    if (cur.getLeft() != null) cur = cur.getLeft();
                    else {
                        cur.setLeft(new TreeNode(d));
                        cur.getLeft().setParent(cur);
                        return ;
                    }
                }
                else {
                    if (cur.getRight() != null) 
                        cur = cur.getRight();
                    else {
                        cur.setRight(new TreeNode(d));
                        cur.getRight().setParent(cur);
                        return ;
                    }
                }
            }
        }
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }

    private void printPreOrderRecurse(TreeNode cur) {
        System.out.print(cur.getData() + " ");
        if (cur.getLeft() != null) 
            printPreOrderRecurse(cur.getLeft());
        if (cur.getRight() != null) 
            printPreOrderRecurse(cur.getRight());
    }

    private void printInOrderRecurse(TreeNode cur) {
        if (cur.getLeft() != null) 
            printInOrderRecurse(cur.getLeft());
        System.out.print(cur.getData() + " ");
        if (cur.getRight() != null) 
            printInOrderRecurse(cur.getRight());
    }

    private void printPostOrderRecurse(TreeNode cur) {
        if (cur.getLeft() != null) 
            printPostOrderRecurse(cur.getLeft());
        if (cur.getRight() != null) 
            printPostOrderRecurse(cur.getRight());
        System.out.print(cur.getData() + " ");
    }

    public TreeNode search(int d) { 
        TreeNode result = searchRecurse(d, root); 
        return (result);
    }

    public TreeNode searchRecurse(int d, TreeNode n) { 
        if (n == null) 
            return (null); 
        if (d == n.getData()) 
            return (n); 
        if (d < n.getData()) 
            return (searchRecurse(d, n.getLeft()));
        return searchRecurse(d, n.getRight());
    }

    public TreeNode searchIter(int key) { 
        if (root.getData() == key) 
            return (root);
        TreeNode current = root; 
        while (current != null) { 
            if (key < current.getData()) { 
                if (current.getLeft() != null) 
                    current = current.getLeft();
            } 
            else {
                if (current.getRight() != null) 
                    current = current.getRight();
            }
            if (current.getData() == key) 
                return (current);
            if (current.getLeft() == null && current.getRight() == null) 
                return (null);
        } //while
        return null;
    }

    public TreeNode getRoot() {
        return (root);
    }
}
