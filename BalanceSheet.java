import java.util.*;

public class BalanceSheet implements Observer {
    private Map<User, Double> amountsOwedByOthers;  // Who owes this user
    private Map<User, Double> amountsOwedToOthers;  // What this user owes to others
    private User ownerUser;  // Owner of this balance sheet

    public BalanceSheet(User ownerUser) {
        this.ownerUser = ownerUser;
        this.amountsOwedByOthers = new HashMap<>();
        this.amountsOwedToOthers = new HashMap<>();
    }

    @Override
    public void update(User owingUser, User owedUser, double amount) {
        if (ownerUser.equals(owingUser)) {
            // This user owes money to someone else
            amountsOwedToOthers.put(owedUser, amountsOwedToOthers.getOrDefault(owedUser, 0.0) + amount);
        }
        if (ownerUser.equals(owedUser)) {
            // Someone else owes money to this user
            amountsOwedByOthers.put(owingUser, amountsOwedByOthers.getOrDefault(owingUser, 0.0) + amount);
        }
        notifyUser("Balance updated for user " + ownerUser.getName());
    }

    public void notifyUser(String message) {
        System.out.println(message);
        System.out.println("User " + ownerUser.getName() + "'s Balance Sheet:");
        System.out.println("Amounts Owed by Others: " + amountsOwedByOthers);
        System.out.println("Amounts Owed to Others: " + amountsOwedToOthers);
    }

    public Map<User, Double> getAmountsOwedByOthers() {
        return amountsOwedByOthers;
    }

    public Map<User, Double> getAmountsOwedToOthers() {
        return amountsOwedToOthers;
    }
}
