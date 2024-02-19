package Lab11;

public class PrimEdge_650147 implements Comparable<PrimEdge_650147>{
    private int u;
    private int v;
    private int weight;

    public PrimEdge_650147(int u, int v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public boolean containVertice(int city){
        if (this.getU() == city) 
            return true;
        else if (this.getV() == city) 
            return true;
        return false;
    }

    public int getOtherSide(int src){
        if (this.getU() == src) 
            return this.getV();
        else if (this.getV() == src) 
            return this.getU();
        else 
            return Integer.MIN_VALUE;
    }

    public int getWeight() {
        return weight;
    }

    public int compareTo(PrimEdge_650147 p) {
        return this.getWeight() - p.getWeight();
    }

    public boolean equals(PrimEdge_650147 p) {
        return this.getOtherSide(u) == p.getOtherSide(p.getU()) && 
                this.getOtherSide(v) == p.getOtherSide(p.getV()) && 
                this.getOtherSide(v) == p.getOtherSide(p.getU()) && 
                this.getOtherSide(u) == p.getOtherSide(p.getV()) && 
                this.getWeight() == p.getWeight();
    }

    @Override
    public String toString() {
        return "PrimEdge [u=" + u + ", v=" + v + ", weight=" + weight + "]";
    }
}