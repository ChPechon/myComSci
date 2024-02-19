package FiniteAuto;

import java.util.LinkedList;
import java.util.Scanner;

public class FiniteAuto {
    Scanner sc;
    String input;
    LinkedList<Integer> inputarr = new LinkedList<>();

    public void run() {
        System.out.println("Input 1 or 0 //seperated by space (Ex: 1 0 0 1)");
        sc = new Scanner(System.in);
        input = sc.nextLine();

        for (int i = 0; i < input.length(); i += 2)
            inputarr.add(input.charAt(i) - 48);
        sc.close();

        Node s0 = new Node("0", false);
        Node s1 = new Node("1", false);
        Node s2 = new Node("2", false);
        Node s3 = new Node("3", true);

        s0.setTransitions(s0, s1);
        s1.setTransitions(s0, s2);
        s2.setTransitions(s0, s3);
        s3.setTransitions(s3, s3);
        s0.processInput(inputarr);
    }
}
