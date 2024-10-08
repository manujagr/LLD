public class CashPayment implements Payment {

    @Override
    public void pay(int cost) {
        System.out.println("Cash Payment is completed for " + cost);
    }
}
