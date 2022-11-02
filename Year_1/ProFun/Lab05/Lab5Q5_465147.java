import java.util.Scanner;

public class Lab5Q5_465147 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4; //level of bush
        int idx = sc.nextInt();
        int c = (n / 2) + 1; // space equation

        for (int m = 0; m < idx; m++) // make bush depends on idx
        {
            for(int i = 1; i < n + 1; i++) // make level of bush
            {
                for (int l = 0; l < c + idx; l++) //make space
                {
                    System.out.printf(" ");
                }
                for(int j = 0; j < ((2 * i) - 1) + (2 * m); j++) //make * (2n-1 for first bush which is odd number)
                {
                    System.out.printf("*");
                }
                System.out.printf("\n"); // new line
                c -= 1; // arrange space
            }
            c = (n / 2) - m; //arrange space
        }
        for (int p = 0; p < idx; p++) //make stalk
        {
            for (int o = 0; o < idx + 2; o++) 
                    {
                        System.out.printf(" ");
                    }
                    System.out.printf("***\n");
        }
    }
}