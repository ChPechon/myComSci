package Lab11;

import java.util.PriorityQueue;
import java.util.Arrays;

public class Prim_650147 {
    private int[][] graph;
    private PriorityQueue<PrimEdge_650147> pq;
    private boolean[] visited;

    public Prim_650147(int[][] g) {
        graph = g;
        resetVisited();
        pq = new PriorityQueue<>();
    }

    public int[][] getMST(){
        return getMST(0);
    }
    
    public int[][] getMST(int source){
        int cur = source;
        int[][] mstGraph = new int[graph.length][graph.length];
        lowerAllValue(mstGraph);
        resetVisited();
        do {
            for (int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] > 0) {
                    PrimEdge_650147 pe = new PrimEdge_650147(cur, i, graph[cur][i]);
                    if (!visited[i] || !visited[cur]) 
                        pq.add(pe);
                }
                visited[cur] = true;
            }
            deleteDupEdgePQ();
            if (pq.size() == 0) 
                break;
            if (pq.peek().getOtherSide(cur) > Integer.MIN_VALUE) {
                mstGraph[cur][pq.peek().getOtherSide(cur)] = pq.peek().getWeight();
                cur = pq.poll().getOtherSide(cur);
            }
            else {
                if(visited[pq.peek().getU()] == true) {
                    mstGraph[pq.peek().getU()][pq.peek().getV()] = pq.peek().getWeight();
                    visited[pq.peek().getV()] = true;
                }
                else {
                    mstGraph[pq.peek().getV()][pq.peek().getU()] = pq.peek().getWeight();
                    visited[pq.poll().getV()] = true;
                }
                
            }
            
        } while (!pq.isEmpty() && contains(visited, false));
        reduceTwowayMST(mstGraph);
        zeroAllIntMinValue(mstGraph);
        return mstGraph;
    }

    private void reduceTwowayMST(int[][] mstGraph){
        for (int i = 1; i < graph.length; i++)
            for (int j = 0; j < i; j++)
                if (mstGraph[i][j] == mstGraph[j][i]) mstGraph[i][j] = 0;
    }

    private void resetVisited(){
        visited = new boolean[graph.length];
    }

    private void deleteDupEdgePQ(){
        while (true) {
            if (visited[pq.peek().getU()] && visited[pq.peek().getV()] && 
                contains(visited, false)) 
                pq.poll();
            else 
                break;
        }
    }

    private void lowerAllValue(int[][] graph){
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph[i].length; j++)
                graph[i][j] = Integer.MIN_VALUE;
    }

    private void zeroAllIntMinValue(int[][] graph){
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph[i].length; j++)
                if(graph[i][j] == Integer.MIN_VALUE) graph[i][j] = 0;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void showTreeAdjacency(int[][] mst){
        for (int i = 0; i < mst.length; i++)
            System.out.println(Arrays.toString(mst[i]));
    }

    private boolean contains(boolean[] barr ,boolean b){
        for (int i = 0; i < barr.length; i++)
            if (barr[i] == b) return true;
        return false;
    }
}
