public class BankPaymentMethod implements PaymentMethod {
    @Override
    public boolean pay(int amount) {
        System.out.println(amount + " is paid using the Bank Account");
        return true;
    }
}
