public class Lab6Q2_165147 {
    public static void main(String args[]) {
      int [] data = {0, 7, 2, -1};
      int idx = data[0];
    
      for (int i = 0; i < data.length; i++)
      {
          idx = Math.max(idx, data[i]);
          System.out.println(idx);
      }
      System.out.println(idx);
    }
}