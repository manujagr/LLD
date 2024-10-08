import java.util.Date;
import java.util.Random;

public class Bill {
    private int billID;
    private Date billDate;
    private Reservation reservation;
    private int billAmount;
    private Payment payment;
    private PaymentStatus paymentStatus;
    public Bill(Reservation reservation, int billAmount, Payment payment) {
        Random random = new Random();
        this.billID = random.nextInt();
        this.billDate = new Date();
        this.reservation = reservation;
        this.billAmount = billAmount;
        this.payment = payment;
        this.paymentStatus = PaymentStatus.PENDING;
    }
}
