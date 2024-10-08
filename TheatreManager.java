import java.util.*;

public class TheatreManager {
    private List<Theatre> theatreList;
    private HashMap<Location, List<Theatre>> theatres;
    private static TheatreManager theatreManager;

    private TheatreManager() {
        theatreList = new ArrayList<>();
        theatres = new HashMap<>();
    }
    public static TheatreManager getInstance() {
        if (theatreManager == null) {
            synchronized (TheatreManager.class) {
                if (theatreManager == null) {
                    theatreManager = new TheatreManager();
                }
            }
        }
        return theatreManager;
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }
    public void addTheatre(Theatre theatre, Location location) {
        theatreList.add(theatre);
        if(theatres.containsKey(location)) {
            theatres.get(location).add(theatre);
        } else {
            List<Theatre> theatresList = new ArrayList<>();
            theatresList.add(theatre);
            theatres.put(location, theatresList);
        }
    }
    public void removeTheatre(Theatre theatre, Location location) {
        theatreList.remove(theatre);
        if(theatres.containsKey(location)) {
            theatres.get(location).remove(theatre);
        }
    }

}
