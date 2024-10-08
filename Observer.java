public interface Observer {

    void update(User owingUserId, User owedUserId, double amount);
}
