public class Lab4Q365147 {
    public static void main(String ... args) {
        int amountCharge = 0;
        int hrsPark = 0;
        for (int i = 0; i < args.length; i++)
        {
            hrsPark = Integer.parseInt(args[i]);
            hrsPark += 1;
            while (hrsPark > 24)
            {
                amountCharge += 24;
                hrsPark -= 24;
            }
            while (--hrsPark > 0)
            {
                if (hrsPark < 24 && hrsPark >= 21)
                    ;
                else if (hrsPark < 21 && hrsPark > 4)
                    amountCharge += 1;
                else if (hrsPark <= 4 && hrsPark > 2)
                    amountCharge += 2;
                else if (hrsPark <= 2 && hrsPark-- > 0)
                    amountCharge += 4;
            }
            System.out.println(amountCharge);
            amountCharge = 0;
        }
    }
}