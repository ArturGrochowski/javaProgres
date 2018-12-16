public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        System.out.println("Your balance befora: " + bankAccount.getBalance());
        bankAccount.start(5);
        System.out.println("Your balance after: " + bankAccount.getBalance());
    }
}
