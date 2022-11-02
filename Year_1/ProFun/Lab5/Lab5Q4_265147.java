public class Lab5Q4_265147 {
    public static void main(String[] args) {
        String str = "Hello Jaa";
        char check;
        int idx = -1;

        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++)
        {
            check = str.charAt(i);
            if (check != 'a' && check != 'e' && check != 'i' 
                && check != 'o' && check != 'u')
                continue;
            idx += i + 1;
            break;
        }
        System.out.println(idx);
    }
}