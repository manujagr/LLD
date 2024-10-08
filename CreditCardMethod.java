public class CreditCardMethod implements PaymentMethod{
    @Override
    public boolean pay(int amount) {
        System.out.println(amount + " is paid using the credit card");
        return true;
    }
}
