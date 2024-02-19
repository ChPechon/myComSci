package Lab10a.code;

public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    public int getData() {
        return (data);
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return (left);
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return (right);
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return (parent);
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        // System.out.println(this.getLeft() + " " + this.getRight());
        if (this.getLeft() != null && this.getRight() != null) 
            return (this.getLeft().getData() + " <- " + data + " -> " + this.getRight().getData() + "\n");
        else if (this.getLeft() != null && this.getRight() == null) 
            return (this.getLeft().getData() + " <- " + data + " -> null" + "\n");
        else if (this.getLeft() == null && this.getRight() != null) 
            return ("null <- " + data + " -> " + this.getRight() + "\n");
        else 
            return ("null <- " + data + " -> null" + "\n"); 
    }
}
