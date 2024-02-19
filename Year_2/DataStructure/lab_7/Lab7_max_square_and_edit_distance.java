package lab_7;
import java.util.Arrays;

public class Lab7_max_square_and_edit_distance {
    public static void main(String[] args) {
        String s1 = "abdc";
        String s2 = "ca";
        System.out.println(q2_string_edit_distance(s1, s2));
    }
    
    private static int q2_string_edit_distance(String str1, String str2) {
        // begin preparation
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : cache)
            Arrays.fill(row, Integer.MAX_VALUE);
        int r;
        for (r = 0; r < cache.length; r++)
            cache[r][str2.length()] = str2.length() - r;

        for (int c = 0; c < cache[0].length; c++)
            cache[str1.length()][c] = str1.length() - c;

        // end preparation
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                // your code
                if(str1.charAt(i) == str2.charAt(j)) {
                    cache[i][j] = cache[i + 1][j + 1];
                } else {
                    int insert = 1 + cache[i][j + 1];
                    int delete = 1 + cache[i + 1][j];
                    int replace = 1 + cache[i + 1][j + 1];

                    int minOperation = Math.min(insert, Math.min(delete, replace));
                    cache[i][j] = minOperation;
                }
                
            }
        }
        return cache[0][0];
    }
}
