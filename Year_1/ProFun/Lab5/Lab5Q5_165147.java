public class Lab5Q5_165147 {
    public static void main(String[] args) {
        int n = 10;
        int f = 0;
        int l = 9;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if (j != f && j != l)
                    System.out.printf("*");
                else
                    System.out.printf(" ");
            }
            System.out.printf("\n");
            f += 1;
            l -= 1;
        }
    }
}