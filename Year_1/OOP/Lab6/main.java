package Lab6;

public class main {
    static void q1() {
        int[] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1};
        Customer yindee = new Customer("Yindee");

        for (int i = 0; i < monthly.length; i++)
            yindee.spend(monthly[i]);
    }

    static void q2() {
        int[] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1};
        Client preeda = new Client("Yindee");

        for (int i = 0; i < monthly.length; i++)
            preeda.spend(monthly[i]);
    }

    static void q3() {
        MemberTypeWithDiscount p = MemberTypeWithDiscount.SILVER;
        MemberTypeWithDiscount q = MemberTypeWithDiscount.SILVER;
        System.out.println(p == q);
    }

    public static void main(String[] args) {
        q1();
        q2();
        q3();
    }
}
