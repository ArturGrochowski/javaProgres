public class BankAccount {
    public BankAccount(double balance) {
        this.balance = balance;
    }

    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void start(double interestRate) {
        Interest interest = new Interest(interestRate);
    }

    class Interest{
        public Interest (double interest){
            this.changeBalace(interest);
        }
        void changeBalace(double interestRate){
            double increase = (balance * interestRate)/100;
            balance += increase;
        }
    }

}
