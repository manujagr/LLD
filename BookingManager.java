import java.util.*;
public class BookingManager {
    private static BookingManager instance;

    private BookingManager() {
        initialize();
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            synchronized (BookingManager.class) {
                if (instance == null) {
                    instance = new BookingManager();
                }
            }
        }
        return instance;
    }

    private void initialize() {
        Location location1 = new Location("Jaipur");
        Location location2 = new Location("Mumbai");
        Location location3 = new Location("Delhi");

        Movie movie1 = new Movie("ABCD1", "2020");
        Movie movie2 = new Movie("ABCD2", "2021");
        Movie movie3 = new Movie("ABCD3", "2022");

        MovieManager movieManager = MovieManager.getInstance();
        movieManager.addMovie(movie1, location1);
        movieManager.addMovie(movie2, location1);
        movieManager.addMovie(movie3, location1);
        movieManager.addMovie(movie2, location2);
        movieManager.addMovie(movie3, location2);
        movieManager.addMovie(movie3, location3);
        movieManager.addMovie(movie1, location3);

        Theatre theatre1 = new Theatre(1, "INOX", location1);
        Theatre theatre2 = new Theatre(2, "PVR", location2);
        Theatre theatre3 = new Theatre(3, "PVR", location3);
        Theatre theatre4 = new Theatre(4, "BIG_CINEMAS", location1);

        Screen screen1 = new Screen(1);
        Screen screen2 = new Screen(2);
        Screen screen3 = new Screen(3);
        Screen screen4 = new Screen(4);
        Screen screen5 = new Screen(5);
        Screen screen6 = new Screen(6);

        theatre1.getScreenList().add(screen1);
        theatre1.getScreenList().add(screen2);
        theatre2.getScreenList().add(screen3);
        theatre2.getScreenList().add(screen4);
        theatre3.getScreenList().add(screen5);
        theatre4.getScreenList().add(screen6);

        TheatreManager theatreManager = TheatreManager.getInstance();
        theatreManager.addTheatre(theatre1, location1);
        theatreManager.addTheatre(theatre2, location2);
        theatreManager.addTheatre(theatre3, location3);
        theatreManager.addTheatre(theatre4, location1);

        Show show1 = new Show(1, movie1, "12 PM", "3 PM");
        Show show2 = new Show(2, movie2, "3 PM", "5 PM");
        Show show3 = new Show(3, movie3, "3 PM", "7 PM");
        Show show4 = new Show(4, movie3, "3 PM", "8 PM");

        theatre1.getShows().add(show1);
        theatre2.getShows().add(show2);
    }

    public Booking createBooking(Location location, Movie movie, Screen screen, List<Seat> seats, Payment payment) {
        TheatreManager theatreManager = TheatreManager.getInstance();
        Theatre theatre = theatreManager.getTheatreByLocation(location);
        Show show = theatre.findShowByMovieAndScreen(movie, screen);

        if (show != null) {
            Booking booking = new Booking(1, movie, seats, payment);
            System.out.println("Booking created for user: " + user.getName());
            return booking;
        } else {
            System.out.println("Show not found for the selected movie and screen.");
            return null;
        }
    }
}
