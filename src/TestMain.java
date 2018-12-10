public class TestMain {
    public static void main(String[] args) {
        WaterBottle[] butelk = new WaterBottle[10];
        for(int i = 0; i<butelk.length; i++){
            double liters = Math.round((Math.random() * 10) * 10.0)/10.0;
            butelk[i] = new WaterBottle(liters);
        }
        for(WaterBottle b : butelk){
            System.out.println(b.getSize());
        }

    }
}
