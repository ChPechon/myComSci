package Lab4.packB;

public class Salesperson extends Employee implements SaleRoles {
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n, exp, sal);
        target = assignedTarget;
    }

    public Salesperson(String n, int exp) {
        super(n);
        setExperience(exp);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return (target);
    }
    
    public void setSalary() {
        this.salary = (salary * 110) / 100;
    }

    public void setSalary(int increasedAmount) {
        this.salary = this.salary + increasedAmount;
    }

    public String makeQuotation() {
        double val = Math.random() * 100;

        return (String.format("Dear Value customer, %f is my best offer.", val));
    }

    public void sayHi() {

    }

}
