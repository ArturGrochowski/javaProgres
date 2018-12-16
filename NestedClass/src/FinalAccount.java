public class FinalAccount {
    private double balance;

    public FinalAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }
    public void createAccount(final double interestRate) { //because of final this parameter is accesible inside Interest class
        class Interest{

            public Interest (double interest){
                this.interest = interest;
                this.changeBalace(); // it take final double interesrRate parameter
            }
            void changeBalace(){ // it take final double interesrRate parameter
                double increase = (balance * interestRate)/100;
                balance += increase;
            }
            private double interest;
        }
        Interest interest = new Interest(interestRate);

    }

}
