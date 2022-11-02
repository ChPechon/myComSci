import java.util.Arrays;

public class Profun09_Q3_65147 {
    public static void main(String[] args) {
        int[][] bMap = {
                { 0, 0, 9, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 0, 0, 0 },
                { 0, 9, 9, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 9, 0, 0, 9, 9, 0, 0, 9, 0, 9, 0, 0 },
                { 0, 9, 0, 0, 9, 9, 0, 0, 9, 9, 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0 }
        };
        int[][] mMap = markMap(bMap);
        
        for (int[] row : mMap) // print each row
            System.out.println(Arrays.toString(row));
    }

    static int[][] markMap(int[][] bMap) {
        for (int Y = 0; Y < bMap.length; Y++) { // run Y-axis
            for (int X = 0; X < bMap[0].length; X++) { // run X-axis
                
                if (bMap[Y][X] != 9) // skip which is not a bomb
                    continue ;
                
                // if its bomb then +1 around it
                for (int sY = -1; sY <= 1; sY++) {
                    for (int sX = -1; sX <= 1; sX++) {
                        try {
                            if (bMap[Y + sY][X + sX] != 9) // except bomb array
                                bMap[Y + sY][X + sX] += 1;
                        } 
                        catch (IndexOutOfBoundsException e) { // error handling
                            continue ;
                        }
                    }
                }
            }
        }
        return (bMap);
    }
}