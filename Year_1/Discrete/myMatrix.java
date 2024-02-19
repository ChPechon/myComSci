import java.util.Arrays;

public class myMatrix {
    public void print(int[][] ans) {
        for (int i = 0; i < ans.length; i++)
            System.out.println(Arrays.toString(ans[i]));
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] ans = new int[a.length][a[0].length];

        for (int Y = 0; Y < a.length; Y++)
            for (int X = 0; X < a[Y].length; X++)
                for (int k = 0; k < a.length; k++)
                    ans[Y][X] += a[Y][k] * b[k][X];
        return (ans);
    }

    public int[][] power(int[][] data, int expo) {
        int[][] ans = data;

        for (int n = 1; n < expo; n++)
            ans = multiply(ans, data);
        return (ans);
    }

    public static void main(String[] args) {
        myMatrix metrix = new myMatrix();
        int[][] data = { { 1, 2, 2, 1 },
                         { 2, 1, 1, 2 },
                         { 2, 1, 1, 2 },
                         { 1, 2, 2, 1 } };
        metrix.print(metrix.power(data, 2));
    }
}
