package Lab11;

public class Plane22Seating extends PlaneSeating {
    public Plane22Seating(String args) {
        super();
        String[] tokens = args.split(",");
        int numRow = tokens.length;
        int numCol = tokens[0].length();
        seating = new char[numRow][numCol];
        for (int i = 0 ; i < tokens.length; i++) {
            seating[i] = tokens[i].toCharArray();
        }
    }

    private boolean isFull(){
        return (false);
    }
}
