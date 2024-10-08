import java.util.List;

public class Booking {
    private int bookingID;
    private List<Seat> seatList;
    private Movie movie;
    private Payment payment;

    public Booking(int bookingID, Movie movie, List<Seat> seatList, Payment payment) {
        this.bookingID = bookingID;
        this.movie = movie;
        this.seatList = seatList;
        this.payment = payment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
