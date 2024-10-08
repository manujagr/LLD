public class CreditCardPayment implements Payment {

    @Override
    public void pay(int cost) {
        System.out.println("Payment via credit card is successful for amount + " + cost);
    }
}
