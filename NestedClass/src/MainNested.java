public class MainNested {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        System.out.println("Your balance befora: " + bankAccount.getBalance());
        bankAccount.start(5);
        System.out.println("Your balance after: " + bankAccount.getBalance());
        FinalAccount finalAccount = new FinalAccount(1500000, 29041986);
        System.out.println("Hello Mr. Artur. Yesterday your balance was: " + finalAccount.getBalance());
        finalAccount.createAccount(12, 100);
        System.out.println("Your current balance is: " + finalAccount.getBalance());
    }
}
