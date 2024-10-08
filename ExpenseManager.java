import java.util.*;

public class ExpenseManager implements Subject{
    private static ExpenseManager instance;
    private List<Expense> expenses;
    private List<Observer> observers;
    private ExpenseManager() {
        expenses = new ArrayList<>();
        observers = new ArrayList<>();
    }
    public static ExpenseManager getInstance() {
        if (instance == null) {
            synchronized (ExpenseManager.class) {
                if (instance == null) {
                    instance = new ExpenseManager();
                }
            }
        }
        return instance;
    }
    public Expense createExpense(String expenseName, double totalAmount, User payer, ExpenseType expenseType, List<Split> splitList) {
        System.out.println("Splitting expenses using strategy: " + expenseType);

//        for (Split split : splitList) {
//            User participant = split.getUser();
//            double owedAmount = split.getAmountOwe();
//
//            if (!participant.equals(payer)) {
//                participant.getBalanceSheet().update(payer, participant, owedAmount);
//            }
//        }
        Expense expense = new Expense(expenseName, totalAmount, payer, expenseType, splitList);
        notifyObservers(expense);
        // Create the expense and add it to the list
        return expense;
    }

    public Expense createGroupExpense(String expenseName, double expenseAmount, User payer, Group group, ExpenseType expenseType, List<Split> splitList) {

        Expense expense = new Expense(expenseName, expenseAmount, payer, expenseType, splitList);
        group.addExpense(expense);
        notifyObservers(expense);
        return expense;
    }
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
    public List<Expense> getAllExpenses() {
        return expenses;
    }
    public Expense getExpenseByID(int id) {
        for (Expense expense : expenses) {
            if(expense.getExpenseID() == id) {
                return expense;
            }
        }
        return null;
    }
    public Expense getExpenseByName(String name) {
        for (Expense expense : expenses) {
            if(expense.getExpenseName().equals(name)) {
                return expense;
            }
        }
        return null;
    }
    public void deleteExpense(Expense expense) {
        expenses.remove(expense);
    }
    public void deleteExpenseByID(int id) {
        for (Expense expense : expenses) {
            if(expense.getExpenseID() == id) {
                expenses.remove(expense);
            }
        }
    }
    public void deleteExpenseByName(String name) {
        for (Expense expense : expenses) {
            if(expense.getExpenseName().equals(name)) {
                expenses.remove(expense);
            }
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Expense expense) {
        User payer = expense.getPaidBy();  // The user who paid the expense

        for (Split split : expense.getSplitList()) {
            User participant = split.getUser();  // Participant in the expense
            double amount = split.getAmountOwe();  // Amount this participant owes

            if (!participant.equals(payer)) {
                // Update the participant's balance sheet (participant owes payer)
                participant.getBalanceSheet().update(participant, payer, amount);

                // Update the payer's balance sheet (payer is owed by participant)
                payer.getBalanceSheet().update(participant, payer, amount);
            }
        }
    }


}
