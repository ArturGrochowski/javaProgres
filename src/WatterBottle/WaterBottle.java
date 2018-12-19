package WatterBottle;

public class WaterBottle {
    private double size;
    private double maxSize = 5.0;

    public WaterBottle(){
        System.out.println("Konstrukto domyślny WaterBottle");
    }

    public WaterBottle(double liters) {
        size = liters;
    }
    double getSize(){
        return size;
    }

    double pour (double howMuch){
        size += howMuch;
        return size;
    }
    boolean pourOut(double howMuch){
        if(size>=howMuch) {
            size -= howMuch;
            return true;
        } else {
            size = 0;
            return false;
        }
    }

    void transfer(double howMuch, WaterBottle where){
        if(pourOut(howMuch)) {
            where.pour(howMuch);
        }else {
            size = howMuch - size;
            where.pourOut(size);
        }
    }

    public static void main(String[] args) {
        WaterBottle[] bottle = new WaterBottle[10];
        for(int i = 0; i<bottle.length; i++){
            bottle[i] = new WaterBottle(Math.round(Math.random() * 100.0)/10.0);
            }
        int i = 0;
        int y = 0;
        System.out.println("0 = " + bottle[0].getSize());
        System.out.println("1 = " + bottle[1].getSize());
        bottle[1].transfer(1, bottle[0]);
        System.out.println("0 = " + bottle[0].getSize());
        System.out.println("1 = " + bottle[1].getSize());
    }
}