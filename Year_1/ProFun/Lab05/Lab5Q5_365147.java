public class Lab5Q5_365147 {
    public static void main(String[] args) {
        int n = 4;
        int c = n / 2;

        for(int i = 1; i < n + 1; i++)
        {
            for (int l = 0; l < c + 1; l++)
            {
                System.out.printf(" ");
            }
            for(int j = 0; j < ((2 * i) - 1); j++)
            {
                System.out.printf("P");
            }
            System.out.printf("\n");
            c -= 1;
        }
    }
}