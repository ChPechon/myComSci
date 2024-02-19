package PrimAlgo;

import java.util.HashMap;

class myMST {
    private int graph[][];
    private HashMap<Integer, String> city;
    private int length;
    private int min;
    private int min_index;
    private int sum;
 
    public myMST(int[][] graph, HashMap<Integer, String> city) {
        this.graph = graph;
        this.city = city;
        this.length = graph[0].length;
        sum = 0;
    }

    private int minKey(int key[], Boolean mstSet[])
    {
        min = Integer.MAX_VALUE;
        min_index = -1;
        for (int v = 0; v < length; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return (min_index);
    }

    private void print(int parent[], int graph[][])
    {
        System.out.println("Destination \t\t\tWeight");
        for (int i = 1; i < length; i++) {
            System.out.printf("%s(%d) -> %s(%d) \t %d\n", 
            city.get(parent[i]), parent[i], city.get(i), i, graph[i][parent[i]]);
            sum += graph[i][parent[i]];
        }
        System.out.println("\nTotal weight : " + sum);
    }
 
    public void primMST() {
        int parent[] = new int[length];
        int key[] = new int[length];
        Boolean mstSet[] = new Boolean[length];
 
        for (int i = 0; i < length; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < length - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
 
            for (int v = 0; v < length; v++)
                if (graph[u][v] != 0 
                    && mstSet[v] == false
                    && graph[u][v] < key[v]) 
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        print(parent, graph);
    }
 
    public static void main(String[] args)
    {
        int[][] graph = {{0, 355, 0, 0, 0, 0, 695, 0},
                         {355, 0, 74, 269, 0, 0, 0, 262},
                         {0, 74, 0, 348, 0, 0, 0, 0},
                         {0, 269, 348, 0, 306, 83, 151, 242},
                         {0, 0, 0, 306, 0, 230, 0, 0},
                         {0, 0, 0, 83, 230, 0, 0, 0},
                         {695, 0, 0, 151, 0, 0, 0, 0},
                         {0, 262, 0, 242, 0, 0, 0, 0}};
        HashMap<Integer, String> city = new HashMap<>();
        city.put(0, "Minneapolis");
        city.put(1, "Chicago");
        city.put(2, "Milwaukee");
        city.put(3, "Louisville");
        city.put(4, "Detroit");
        city.put(5, "Cincinnati");
        city.put(6, "Nashville");
        city.put(7, "St.Louis");
        myMST myGraph = new myMST(graph, city);
        myGraph.primMST();
    }
}
