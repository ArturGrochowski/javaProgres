package main;

import monsters.Monster;
import monsters.IActions;
import monsters.Skeleton;
import monsters.Zombie;

public class MainInherit {
    public static void main(String[] args) {
        IActions[] nameTab = new IActions[4];
        Monster m = new Monster(10, 100);
        Zombie z = new Zombie();
        Skeleton s = new Skeleton(15, 20, "Sword and Bow");
        Monster mS = new Skeleton(); /* Polymorphism | in that case if I implement someMethod() inside of Skeleton Class I won't be able to access this method
         by mS.someMethod(); because I will refer to Monster class where someMethod() doesn't exist. I can create an object Skeleton mS = new Skeleton
         and then I will be able do mS.someMethod(); */
        System.out.println("Walka speed of " + m.getName() + " = " + m.getWalkSpeed());
        monsterName(z);
        nameTab[0] = m;
        nameTab[1] = z;
        nameTab[2] = s;
        nameTab[3] = mS;
        for(IActions name : nameTab){
            name.showName();
            name.attack();
        }
    }

    static void monsterName(Monster monsterName){
        System.out.println("You sended " + monsterName.getName() + " to test method");
    }
}