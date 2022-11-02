public class Lab5Q4_165147 {
    public static void main(String[] args) {
        String str = "WWWWMMMMWMWMWMWMMMWWWWWM";
        int W = 0;
        int M = 0;

        for(int i = 0;i < str.length(); i++)
        {
            if (str.charAt(i) == 'W')
                W += 1;
            else if (str.charAt(i) == 'M')
                M += 1;
        }
        System.out.println(W);
        System.out.println(M);
    }
}