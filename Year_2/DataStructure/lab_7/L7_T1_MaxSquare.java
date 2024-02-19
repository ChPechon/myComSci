package lab_7;

public class L7_T1_MaxSquare {
    private static int[][] matrix;
    private static int rows;
    private static int cols;
    private static int max_so_far_for_recursion = -1;

    public static void main(String[] args) {
        int[][] m1 = { { 1, 1, 0, 1, 0, 0 },
                        { 0, 1, 1, 1, 1, 1 }, 
                        { 1, 0, 1, 1, 1, 0 }, 
                        { 0, 0, 1, 1, 1, 0 } };
        System.out.println(find_max_area_recurse_entry(m1));
    }

    public static int find_max_area_recurse_entry(int[][] mat) {
        matrix = mat;
        rows = matrix.length;
        cols = matrix[0].length;

        q1_1_find_max_area_recurse(matrix, 0, 0);
        return max_so_far_for_recursion * max_so_far_for_recursion;
    }

    private static int q1_1_find_max_area_recurse(int[][] mat, int r, int c) {
        if (r == rows || c == cols)
            return 0;
        // my code
        if (mat[r][c] == 0)
            return 0;
        int size = mat[r][c];

        int rightSize = q1_1_find_max_area_recurse(mat, r, c + 1);

        int downSize = q1_1_find_max_area_recurse(mat, r + 1, c);

        int diagonalSize = q1_1_find_max_area_recurse(mat, r + 1, c + 1);

        int minSize = Math.min(rightSize, Math.min(downSize, diagonalSize));
        size += minSize;

        max_so_far_for_recursion = size > max_so_far_for_recursion ? size : max_so_far_for_recursion;
        return size;
    }

}
