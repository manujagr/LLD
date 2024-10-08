import java.util.*;

public class MovieManager {
    private HashMap<Location, List<Movie>> movies;
    private List<Movie> movieList;
    private static MovieManager movieManager;
    private MovieManager() {
        movies = new HashMap<>();
        movieList = new ArrayList<>();
    }
    public static MovieManager getInstance() {
        if(movieManager == null) {
            synchronized (MovieManager.class) {
                if(movieManager == null) {
                    movieManager = new MovieManager();
                }
            }
        }
        return movieManager;
    }

    public void addMovie(Movie movie, Location location) {
        if(movies.containsKey(location)) {
            movies.get(location).add(movie);
        }
        else {
            List<Movie> list = new ArrayList<>();
            list.add(movie);
            movies.put(location, list);
        }
        movieList.add(movie);
    }
    public List<Movie> getMovieByLocation(Location location) {
        return movies.getOrDefault(location, null);
    }
    public List<Movie> getMovies() {
        return movieList;
    }
    public Movie getMovie(Movie movie) {
        return movieList.get(movieList.indexOf(movie));
    }
}
