package Lab3.packA;
import Lab3.EmpTmp;

public class Programmer extends EmpTmp {
    private String name;
    protected int salary;
    private int experience;

    public Programmer(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public Programmer(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public Programmer(String name) {
        this.name = name;
    }

    public Programmer() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return (name);
    }

    public void setSalary(int newSalary) {
        salary = newSalary;
    }

    public int getSalary() {
        return (salary);
    }

    public void setExperience(int exp) {
        experience = exp;
    }

    public int getExperience() {
        return (experience);
    }

    public String toString() {
        return (String.format("[name=%s, salary=%d, experience=%d]", name, salary, experience));
    }

    public void sayHi() {
        System.out.println("hi from " + name);
    }

    public String coding() {
        return (String.format(""));
    }
}
