package Lab4.packB;

public class ProgrammerManager extends Programmer implements ManagerRoles {
    public ProgrammerManager(String name, int experience, int salary) {
        super(name, experience, salary);
    }
    
    public void sayHi() {
        addSkills("Solidity");
        addSkills("Typescript");
        System.out.println("Coding in " + getSkills());
    }

    public String coding() {
        return ("");
    }

    @Override
    public int evaluate(Programmer p) {
        p.salary = (p.salary * 115) / 100;
        return (p.salary);
    }
}
