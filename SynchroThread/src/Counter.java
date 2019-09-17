public class Counter {

    public void increaseCounter(){
        counter++;
        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }

    public void decreaseCounter(){

        counter--;
        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }

    private int counter = 0;

}
