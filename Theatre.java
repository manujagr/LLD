import java.util.*;

public class Theatre {
    private int id;
    private String name;
    private Location location;
    private List<Show> shows;
    private List<Screen> screenList;
    public Theatre(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.shows = new ArrayList<>();
        this.screenList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }
}
