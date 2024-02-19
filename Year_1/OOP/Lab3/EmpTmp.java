package Lab3;

public class EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;

    public EmpTmp(String n, int exp, int sal) {
        name = n;
        experience = exp;
        salary = sal;
    }

    public EmpTmp(String n) {
        name = n;
    }

    public EmpTmp() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return (name);
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return (salary);
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return (experience);
    }

    public String toString() {
        return (String.format("[name=%s, experience=%d, salary=%d]", name, experience, salary));
    }

    public void sayHi() {
        System.out.println("Hi am EmpTmp");
    }
}
