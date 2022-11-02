public class Lab5Q365147 {
    public static void main(String[] args) {
        int n;

        n = 0;
        for(int i = 0; i <= 199; i++)
        {
            if (i % 10 == 0)
                continue;
            n += i;
        }
        System.out.println(n);
    }
}