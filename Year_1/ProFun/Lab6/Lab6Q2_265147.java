public class Lab6Q2_265147 {
    public static void main(String args[]) {
      String input = "10 10 10 01 10 10";
      int inputLength = input.length();
      int idx = 1;
      
      if (inputLength == 0)
      {
          System.out.println(0);
          return ;
      }
      for (int i = 0; i < inputLength - 3; i += 3)
      {
          if (input.charAt(i) == input.charAt(i + 3))
            continue ;
          idx += 1;
      }
      System.out.println(idx);
    }
}