public class Lab5Q5_265147 {
    public static void main(String[] args) {
        int n = 4;
        for(int i = n; i > 0; i--)
        {
            for(int j = n; j > i - 1; j--)
            {
                    System.out.printf("%d ",j);
            }
            System.out.printf("\n");
        }
    }
}