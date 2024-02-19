package Lab4.packB;

public class Accountant extends Employee {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp,int experience,int sal,String talent){
        super(name,superExp, sal);
        this.experience = experience;
        specialty = talent;
    }
    
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return (experience);
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return (specialty);
    }

    public void sayHi() {

    }

    public String tellProfit() {
        return ("");
    }

    public static String tellMyRole() {
        return (String.format("%s",companyName));
    }
}
