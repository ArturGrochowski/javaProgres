class MainExcept {
    private double size;
    private double maxSize = 5.0;

    private MainExcept(){
        System.out.println("Konstrukto domyślny WaterBottle");
    }

    private MainExcept(double liters) {
        size = liters;
    }
    private double getSize(){
        return size;
    }

    private double pour (double howMuch){
        size += howMuch;
        return size;
    }
    private void pourOut(double howMuch) throws Exception {
        if(size>=howMuch) {
            size -= howMuch;
        } else {
            throw new LackOfWatter("not enough water");
        }
    }

    private void transfer(double howMuch, MainExcept where) throws Exception {
        this.pourOut(howMuch);
            where.pour(howMuch);
        }

    public static void main(String[] args) {
        MainExcept[] bottle = new MainExcept[3];
//        for(int i = 0; i<bottle.length; i++){
//            bottle[i] = new MainExcept(Math.round(Math.random() * 100.0)/10.0);
//        }
        bottle[0] = new MainExcept(5);
        bottle[1] = new MainExcept(5);
        bottle[2] = new MainExcept(5);
        int i = 0;
        int y = 0;
        System.out.println("Bottle A = " + bottle[0].getSize());
        System.out.println("Bottel B = " + bottle[1].getSize());
        try {
            bottle[1].transfer(6, bottle[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Bottle A = " + bottle[0].getSize());
        System.out.println("Bottle B = " + bottle[1].getSize());
    }
}

class LackOfWatter extends Exception{
    protected LackOfWatter(String message) {
        super(message);
    }
}