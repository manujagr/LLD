import java.util.List;

public interface ExpenseStrategy {
    public void splitExpenses(List<Split> splitList, double amount);
}
