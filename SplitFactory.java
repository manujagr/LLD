public class SplitFactory {
    public static ExpenseStrategy getSplitObject(ExpenseType expenseType ){
        return switch (expenseType) {
            case ExpenseType.EQUAL -> new EqualExpenseStrategy();
            case ExpenseType.PERCENTAGE -> new PercentageExpenseStrategy();
            default -> null;
        };
    }
}
