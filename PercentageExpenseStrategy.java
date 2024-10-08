import java.util.List;

public class PercentageExpenseStrategy implements ExpenseStrategy {

    @Override
    public void splitExpenses(List<Split> splitList, double amount) {
        System.out.println("Split expenses by percentage");
    }
}
