public class Lab7Q2_65147 {
    static int maxElement(int [] arr)
    {
        int result;
        
        result = arr[0];
        for (int i = 1; i < arr.length; i++)
            result = Math.max(result, arr[i]);
        return (result);
    }
    public static void main(String args[])
    {
      int [] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
      System.out.println(maxElement(data));
    }
}