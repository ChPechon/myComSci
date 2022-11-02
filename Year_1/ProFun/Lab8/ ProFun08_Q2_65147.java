public class ProFun08_Q2_65147 {

    static int kadane(int a[])
    {
        int theMax = Integer.MIN_VALUE;
        int curMax = 0;
        int s = 0;

        for (int i = 0; i < a.length; i++) 
        {
            curMax += a[i];
            if (theMax < curMax) 
                theMax = curMax;
            if (curMax < 0)
            {
                curMax = 0;
                s += 1;
            }
        }
        return (theMax);
    }

    public static void main(String[] args)
    {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("answer is : " + kadane(a));
    }
}