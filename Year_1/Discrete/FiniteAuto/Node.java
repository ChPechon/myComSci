package FiniteAuto;

import java.util.LinkedList;

class Node {
    private Node zeroNode;
    private Node oneNode;
    private boolean isFinalState;
    private String name;

    Node(String name, boolean isFinalState) {
        this.name = name;
        this.isFinalState = isFinalState;
    }

    public void setTransitions(Node zeroNode, Node oneNode) {
        this.zeroNode = zeroNode;
        this.oneNode = oneNode;
    }

    public void processInput(LinkedList<Integer> get) {
        System.out.println("Node: " + name + ", Input: " + get);

        if (!get.isEmpty()) {
            int firstBit = get.remove(0);
            if (firstBit == 0)
                zeroNode.processInput(get);
            else
                oneNode.processInput(get);
        }

        if (isFinalState)
            System.out.println("accept");
        else
            System.out.println("reject");
        System.exit(0);
    }
}
