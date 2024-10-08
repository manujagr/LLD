import java.util.*;

public class UserManager {
    private static UserManager userManager;
    private List<User> userList;
    private UserManager() {
        userList = new ArrayList<>();
    }
    public static UserManager getInstance() {
        if (userManager == null) {
            synchronized (UserManager.class) {
                if (userManager == null) {
                    userManager = new UserManager();
                }
            }
        }
        return userManager;
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public void removeUser(User user) {
        userList.remove(user);
    }
    public List<User> getUserList() {
        return userList;
    }
    public User getUser(int id) {
        for (User user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
