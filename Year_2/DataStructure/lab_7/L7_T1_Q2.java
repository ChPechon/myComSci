package lab_7;

public class L7_T1_Q2 {
    public static void main(String[] args) {
        int[][] data = { { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, } };
        q1_2_maximum_size_square_sub_matrix(data);
    }

    public static void q1_2_maximum_size_square_sub_matrix(int[][] data) {
        int maxSize = 0;
        if (data == null || data.length == 0 || data[0].length == 0)
            maxSize = 0;

        int m = data.length;
        int n = data[0].length;
        int[][] sub = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (data[i - 1][j - 1] == 1) {
                    sub[i][j] = Math.min(sub[i - 1][j], Math.min(sub[i][j - 1], sub[i - 1][j - 1])) + 1;
                    maxSize = Math.max(maxSize, sub[i][j]);
                }
            }
        }
        System.out.println("Maximum size square sub-matrix with all 1s: " + maxSize);
    }
}