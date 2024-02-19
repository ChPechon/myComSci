package Lab3.packA;
import Lab3.EmpTmp;

public class Accountant extends EmpTmp {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp,int experience,int sal,String talent){
        super(name,superExp, sal);
        this.experience = experience;
        specialty = talent;
    }
    
    public int getAccountExperience() {
        return (experience);
    }

    public void setAccountExperience(int experience) {
        this.experience = experience;
    }

    public String getSpecialty() {
        return (specialty);
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String tellProfit(){
        double random = Math.random() * 1000;
        int newR = (int) random;
        return (companyName +"'s profit is " + newR +". My salary is "+ getSalary());
    }

    @Override
    public String toString() {
        return ("Accountant [experience=" + experience + ", specialty=" + specialty + "]");
    }

    @Override
    public void sayHi(){
        System.out.println(getName() + " says hello");
    }

    public static String tellMyRole() {
        return (String.format("I am an accountant at %s", companyName));
    }
}
