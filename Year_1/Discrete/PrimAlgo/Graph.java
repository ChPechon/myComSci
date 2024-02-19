package PrimAlgo;

class Graph {
    private int[][] graph;
    private int length;
 
    public Graph(int[][] graph) {
        this.graph = graph;
        length = graph[0].length;
    }
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < length; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed MST
    // stored in parent[]
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                               + graph[i][parent[i]]);
    }
 
    // Function to construct and print MST for a graph
    // represented using adjacency matrix representation
    void primMST()
    {
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
                if (graph[u][v] != 0 && mstSet[v] == false
                    && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
 
        // Print the constructed MST
        printMST(parent, graph);
    }
 
    public static void main(String[] args)
    {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };
        Graph t = new Graph(graph);
        // Print the solution
        t.primMST();
    }
}
 
