package inheritance.main;

import inheritance.monsters.Monster;
import inheritance.monsters.Skeleton;
import inheritance.monsters.Zombie;

public class Main{
    public static void main(String[] args) {
        System.out.println("Making Monster with 2 arguments:");
        Monster m = new Monster(10, 100);
        System.out.println("Making Zombie with no arguments:");
        Zombie z = new Zombie();
        System.out.println("Making Skeleton with 2 arguments:");
        Skeleton s = new Skeleton(15, 20, "Sword and Bow");
        System.out.println("Polymorphism example with no arguments:");
        Monster mS = new Skeleton(); // Polymorphism
        System.out.println(m.getWalkSpeed());
        s.attack();
        monsterName(z);
    }
    static void monsterName(Monster monsterName){
        System.out.println("You sended " + monsterName.getName() + " to test method");
    }
}