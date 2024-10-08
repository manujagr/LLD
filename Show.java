import java.util.*;

public class Show {
    private int showId;
    private Movie movie;
    private String startTime;
    private String endTime;
    List<Seat> occupiedSeats;
    public Show(int showId, Movie movie, String startTime, String endTime) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
