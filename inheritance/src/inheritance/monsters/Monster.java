package inheritance.monsters;

public class Monster implements IActions {
    String name = "Monster";

    @Override
    public String showName(){
        System.out.println("monster: " + name);
        return name;
    }

    public String getName(){
        return name;
    }

    public double getWalkSpeed(){
        return walkSpeed;
    }
    public double getHitPoint(){
        return hitPoint;
    }
    public void setWalkSpeed(double walkSpeed){
        this.walkSpeed = walkSpeed;
    }
    public void setHitPoint(double hitPoint) {
        this.hitPoint = hitPoint;
    }

    private double walkSpeed = 10;
    private double hitPoint = 100;

    public void attack(){
        System.out.println("This is the attack method from Monster class");
    }

    public Monster(){
        System.out.println("Default constructor from Monster class");
    }

    public Monster(double walkSpeed, double hitPoint){
        setWalkSpeed(walkSpeed); // whith no setters would be: this.walkSpeed = walkSpeed;
        setHitPoint(hitPoint);
        System.out.println("Non-default constructor form Monster class");
    }
}
