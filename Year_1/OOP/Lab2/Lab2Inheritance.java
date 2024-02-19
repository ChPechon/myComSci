import packA.*;

public class Lab2Inheritance {
    public static void main(String[] args) {
        q1();
    }

    static void q1() {
        var p1 = new Programmer("ber1", 2, 500);
        System.out.println(p1);
        p1.sayHi();
    }

    static void q2_Salesperson() {
        Salesperson p2 = new Salesperson("mr.salesperson", 5, 150, 5000);
        Salesperson p3 = new Salesperson("mr.kayan", 4, 260, 9000);
        System.out.println("example of inherited method " + p2.getName());
        System.out.println(p2.makeQuotation());
        System.out.print("another example of inherited method ");
        p3.sayHi();
        System.out.println("notice the result of overridden setSalary(int incresedAmount) below");
        System.out.print(p2.getName() + "'s salary was " + p2.getSalary() + " -> ");
        p2.setSalary(100);
        System.out.println(p2);
        p2.setSalary();
        System.out.println(p2);
        System.out.println(p3);
        // example of inherited method mr.salesperson
        // Dear value customer, 898 is my best offer.
        // another example of inherited method hi from mr.kayan
        // notice the result of overridden setSalary(int incresedAmount) below
        // mr.salesperson's salary was 150 -> Salesperson [target=5000 Programmer
        // [name=mr.salesperson, salary=250, experience=5] ]
        // Salesperson [target=5000 Programmer [name=mr.salesperson, salary=275,
        // experience=5] ]
        // Salesperson [target=9000 Programmer [name=mr.kayan, salary=260, experience=4]
        // ]
    }
}
