public class FinalAccount {
    private double balance;
    private int id;

    public FinalAccount(double balance, int id) {
        this.balance = balance;
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void createAccount(final double interestRate, double percent) {
        class Interest{
            public Interest (){
                this.changeBalace(); //because this class/constructor is inside method it has direct access to method parameters.
            }
            void changeBalace(){ //those parameter are used below:
                double increase = (balance * interestRate)/percent;
                balance += increase;
            }
        }
        Interest interest = new Interest(); // bedause of final argument in createAccount method
    }
}
