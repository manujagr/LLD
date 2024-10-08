import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to Best Car Parking Services!");
        EntranceGate entranceGate = EntranceGate.getInstance();
        ExitGate exitGate = ExitGate.getInstance();

        TwoWheelerParkingSpot twoWheelerParkingSpot = new TwoWheelerParkingSpot(1, VehicleType.TwoWheeler, Status.Free);
        ThreeWheelerParkingSpot threeWheelerParkingSpot = new ThreeWheelerParkingSpot(1, VehicleType.ThreeWheeler, Status.Free);
        FourWheelerParkingSpot fourWheelerParkingSpot = new FourWheelerParkingSpot(1, VehicleType.FourWheeler, Status.Free);

        List<TwoWheelerParkingSpot> twoWheelerParkingSpotList = new ArrayList<>();
        twoWheelerParkingSpotList.add(twoWheelerParkingSpot);
        List<ThreeWheelerParkingSpot> threeWheelerParkingSpotList = new ArrayList<>();
        threeWheelerParkingSpotList.add(threeWheelerParkingSpot);
        List<FourWheelerParkingSpot> fourWheelerParkingSpotList = new ArrayList<>();
        fourWheelerParkingSpotList.add(fourWheelerParkingSpot);

        TwoWheelerParkingSpotManager twoWheelerParkingSpotManager = new TwoWheelerParkingSpotManager(twoWheelerParkingSpotList);
        ThreeWheelerParkingSpotManager threeWheelerParkingSpotManager = new ThreeWheelerParkingSpotManager(threeWheelerParkingSpotList);
        FourWheelerParkingSpotManager fourWheelerParkingSpotManager = new FourWheelerParkingSpotManager(fourWheelerParkingSpotList);

        FourWheelerVehicle fourWheelerVehicle = new FourWheelerVehicle("Rj!4 XCAW", VehicleType.FourWheeler);
        ThreeWheelerVehicle threeWheelerVehicle = new ThreeWheelerVehicle("Rj!4 XCAW", VehicleType.ThreeWheeler);
        FourWheelerVehicle fourWheelerVehicle1 = new FourWheelerVehicle("Rj!4 XCAW", VehicleType.FourWheeler);

        ParkingSpot freeFourWheelerSpot = entranceGate.findParkingSpot("4wheeler", fourWheelerParkingSpotList);
        Ticket ticket1 = null;
        Ticket ticket2 = null;
        if (freeFourWheelerSpot != null) {
            System.out.println("Found a free spot for 4-wheeler: " + freeFourWheelerSpot.getId());
            fourWheelerParkingSpotManager.bookParkingSpot((FourWheelerParkingSpot) freeFourWheelerSpot);
            System.out.println("Spot " + freeFourWheelerSpot.getId() + " is now occupied.");
            ticket1 = new Ticket(freeFourWheelerSpot);
        } else {
            System.out.println("No free parking spot available for 4-wheeler.");
        }

        ParkingSpot freeThreeWheelerSpot = entranceGate.findParkingSpot("3wheeler", threeWheelerParkingSpotList);

        if (freeThreeWheelerSpot != null) {
            System.out.println("Found a free spot for 3-wheeler: " + freeThreeWheelerSpot.getId());
            threeWheelerParkingSpotManager.bookParkingSpot((ThreeWheelerParkingSpot) freeThreeWheelerSpot);
            System.out.println("Spot " + freeThreeWheelerSpot.getId() + " is now occupied.");
            ticket2 = new Ticket(freeThreeWheelerSpot);
        } else {
            System.out.println("No free parking spot available for 3-wheeler.");
        }

        PaymentMethod paymentMethod = new CreditCardMethod();

        int parkingFee = exitGate.calculateParkingFee(paymentMethod,"4wheeler", fourWheelerParkingSpotList, ticket1);
        System.out.println("Parking fee for 4-wheeler: " + parkingFee);

//        PaymentMethod paymentMethod = new CreditCardPayment();
//        boolean paymentSuccess = exitGate.payParkingFee(paymentMethod, parkingFee);
//        if (paymentSuccess) {
//            System.out.println("Payment was successful!");
//        } else {
//            System.out.println("Payment failed.");
//        }

    }
}