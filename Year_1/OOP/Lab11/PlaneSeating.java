package Lab11;

public abstract class  PlaneSeating {
    protected char[][] seating;
    
    public void showSeating() {
        for(int i = 0 ; i < seating.length;i++) {
            System.out.print("row " + (i + 1) + " --> ");
            for(int j = 0; j < seating.length; j++) {
                System.out.print(seating[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int col) {
        if(this.seating[row - 1][col - 1] == '^') {
            this.seating[row - 1][col - 1] = 'x';
            return (true);
        }
        return (false);
    }
}
