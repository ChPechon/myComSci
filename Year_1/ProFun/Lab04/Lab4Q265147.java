import java.util.Scanner;

public class Lab4Q265147 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int sum = 0;
    
    sum = a + b + c;
    if (a < b && a < c)
        sum -= a;
    else if (b < a && b < c)
        sum -= b;
    else
        sum -= c;
    
    System.out.println(sum);
  }
}