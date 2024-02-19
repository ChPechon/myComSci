package PrimAlgo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        graph.addEdge("Minnepolis", "Chicago", 355);
        graph.addEdge("Minnepolis", "Nashville", 695);
        graph.addEdge("Milwaukee", "Chicago", 74);
        graph.addEdge("Milwaukee", "Louisville", 348);
        graph.addEdge("Chicago", "Louisville", 348);
        graph.addEdge("Chicago", "St. Louis", 262);
        graph.addEdge("St. Louis", "Louisville", 242);
        graph.addEdge("Detroit", "Cincinnati", 230);
        graph.addEdge("Detroit", "Louisville", 306);
        graph.addEdge("Cincinnati", "Louisville", 83);
        graph.addEdge("Louisville", "Nashville", 151);
        System.out.print("Enter the starting node: ");
        String start = sc.nextLine();
        System.out.println();
        List<String> mst = graph.prim(start);
        int totalWeight = 0;
        for (String edge : mst) {
            System.out.println(edge);
            String[] tokens = edge.split(" ");
            String lastToken = tokens[tokens.length - 1];
            if (lastToken.matches("\\d+")) {
                totalWeight += Integer.parseInt(lastToken);
            }
        }
        System.out.println();
        System.out.println("Total weight of MST: " + totalWeight);
        sc.close();
    }
}