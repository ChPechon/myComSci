import java.util.ArrayList;

class myGraph {
    public ArrayList<String> node;
    public ArrayList<ArrayList<String>> next;

    myGraph(String... node) {
        this.node = new ArrayList<>();
        for (String str : node)
            this.node.add(str.toUpperCase());
        next = new ArrayList<>(this.node.size());
        for (int i = 0; i < this.node.size(); i++)
            next.add(new ArrayList<>());
    }

    public void setRelation(String vertex, String... value) {
        for (String str : value) {
            next.get(node.indexOf(vertex)).add(str);
            if (str != vertex)
                next.get(node.indexOf(str)).add(vertex);
        }
    }

    public int showDegree(String vertex) {
        int degree = 0;
        for (String str : next.get(node.indexOf(vertex)))
            if (str == vertex)
                degree += 1;
        return (degree + next.get(node.indexOf(vertex)).size());
    }

    public void info() {
        for (String vertex : node)
            System.out.printf("Degree of %s = %d %s \n",
            vertex, showDegree(vertex), next.get(node.indexOf(vertex)));
    }

    public static void main(String[] args) {
        myGraph G = new myGraph("A", "B", "C", "D", "E", "F");
        G.setRelation("A", "A", "B", "C");
        G.setRelation("C", "B", "E");
        G.setRelation("D", "D");
        G.info();
    }
}