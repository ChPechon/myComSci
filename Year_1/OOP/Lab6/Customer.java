package Lab6;

public class Customer implements CanPay {
    private String  name;
    private MemberType memberType;
    
    public Customer(String name) {
        this.name = name;
        memberType = MemberType.None;
    }

    private void promoteMemberType() {
        switch (memberType)
        {
            case None:
                memberType = MemberType.SILVER;
                break ;
            case SILVER:
                memberType = MemberType.GOLD;
                break ;
            case GOLD:
                memberType = MemberType.PREMIUM;
                break ;
            default:
                break ;
        }
    }

    private void demoteMemberType() {
        switch (memberType)
        {
            case PREMIUM:
                memberType = MemberType.GOLD;
                break ;
            case GOLD:
                memberType = MemberType.SILVER;
                break ;
            case SILVER:
                memberType = MemberType.None;
                break ;
            default:
                break ;
        }
    }

    public void showMembershipStatus() {
        System.out.println(name + " is now " + memberType);
    }

    public void spend(int direction) {
        if (direction > 0)
            promoteMemberType();
        if (direction < 0)
            demoteMemberType();
        showMembershipStatus();
    }
}