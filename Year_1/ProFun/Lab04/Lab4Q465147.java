public class Lab4Q465147 {
    public static void main(String[] args) {
        int num = 0;
        int sum = 0;
        int result = 0;
        
        while (result < 3)
        {
            num += 1;
            for (int i = 1; i <= num / 2; i++)
            {
                if (num % i == 0)
                    sum += i;
            }
            if (sum == num && num != 1)
            {
                System.out.println(num);
                result += 1;
            }
            sum = 0;
        }
    }
}