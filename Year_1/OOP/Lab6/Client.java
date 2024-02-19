package Lab6;

public class Client implements CanPay {
    String  name;
    MemberTypeWithDiscount  memberType;

    public Client(String name) {
        this.name = name;
        memberType = MemberTypeWithDiscount.None;
    }

    private void promoteMemberType() {
        switch (memberType)
        {
            case None:
                memberType = MemberTypeWithDiscount.SILVER;
                break ;
            case SILVER:
                memberType = MemberTypeWithDiscount.GOLD;
                break ;
            case GOLD:
                memberType = MemberTypeWithDiscount.PREMIUM;
                break ;
            default:
                break ;
        }
    }

    private void demoteMemberType() {
        switch (memberType)
        {
            case PREMIUM:
                memberType = MemberTypeWithDiscount.GOLD;
                break ;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break ;
            case SILVER:
                memberType = MemberTypeWithDiscount.None;
                break ;
            default:
                break ;
        }
    }

    public void showMembershipStatus() {
        System.out.println(String.format("%s is now %s %.0f%% discount on Product %.0f%% on service"
        , name, memberType, DiscountRate(), ProductRate()));
    }

    private double ProductRate() {
        return (memberType.getProductDiscount() * 10);
    }

    private double DiscountRate() {
        return (memberType.getServiceDiscount() * 10);
    }

    public void spend(int direction) {
        if (direction > 0)
            promoteMemberType();
        if (direction < 0)
            demoteMemberType();
        showMembershipStatus();
    }
}
