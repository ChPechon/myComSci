package Lab4.packB;

public abstract class Employee {
    protected String name;
    protected int experience;
    protected int salary;

    public abstract void sayHi();

    public Employee(String n, int exp, int sal) {
        name = n;
        experience = exp;
        salary = sal;
    }

    public Employee(String n) {
        name = n;
    }

    public Employee() {

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
}
