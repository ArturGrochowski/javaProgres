package inheritance.monsters;

public class Zombie extends Monster{
    String name = "Zombie";

    @Override
    public String getName() {
        return name;
    }

    public Zombie() {
        System.out.println("Default constructor form Zombie class");
    }

    public Zombie(double walkSpeed, double hitPoint) {
        super(walkSpeed, hitPoint);
        System.out.println("Non-default constructor form Zombie class");
    }
}
