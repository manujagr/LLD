import java.util.*;

public class Expense {
    private int expenseID;
    private String expenseName;
    private double expenseAmount;
    private User paidBy;
    private Date date;
    private ExpenseType expenseType;
    private List<Split> splitList;
    public Expense(String expenseName, double expenseAmount, User user, ExpenseType expenseType, List<Split> splitList) {
        Random  random = new Random();
        this.expenseID = random.nextInt();
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.paidBy = user;
        this.date = new Date();
        this.expenseType = expenseType;
        this.splitList = splitList;
    }

    public int getExpenseID() {
        return expenseID;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public Date getDate() {
        return date;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
