package inheritance.monsters;

public class Skeleton extends Monster implements IActions {
    String name = "Skeleton";
    String weapon;

    @Override
    public String showName() {
        System.out.println("Skleleton: " + name);
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Skeleton() {
        System.out.println("Default constructor form Skeleton class");
    }

    public Skeleton(double walkSpeed, double hitPoint) {
        super(walkSpeed, hitPoint);
        System.out.println("Non-default constructor form Skeleton class");

    }

    public Skeleton(double walkSpeed, double hitPoint, String weapon) {
        super(walkSpeed, hitPoint);
        this.weapon = weapon;
        System.out.println("Non-default constructor form Skeleton class");

    }
    @Override
    public void attack(){
        super.attack();
        System.out.println("This is the attack method frmo Skeleton class");
    }
}