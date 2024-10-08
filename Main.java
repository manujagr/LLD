import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to the Splitwise!");
        UserManager userManager = UserManager.getInstance();
        GroupManager groupManager = GroupManager.getInstance();
        ExpenseManager expenseManager = ExpenseManager.getInstance();

        User user1 = new User(1, "Manuj", "manujagarwal19997@gmail.com");
        User user2 = new User(2, "Somil", "somil2760@gmail.com");
        User user3 = new User(3, "Pratyay", "pratyaySingh@gmail.com");
        User user4 = new User(4, "Devendra", "devendra@gmail.com");

        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.addUser(user3);
        userManager.addUser(user4);

        List<User> groupUsers = new ArrayList<>();
        groupUsers.add(user1);
        groupUsers.add(user2);
        groupUsers.add(user3);
        Group group = new Group("Trip to Goa", groupUsers);
        //group.addExpense(e);
        groupManager.addGroup(group);
        expenseManager.registerObserver(user1.getBalanceSheet());
        expenseManager.registerObserver(user2.getBalanceSheet());
        expenseManager.registerObserver(user3.getBalanceSheet());
        expenseManager.registerObserver(user4.getBalanceSheet());

        List<Split> splitList1 = new ArrayList<>();
        List<Split> splitList2 = new ArrayList<>();
        splitList1.add(new Split(user1, 200));
        splitList1.add(new Split(user2, 200));
        splitList1.add(new Split(user3, 200));
        splitList2.add(new Split(user4, 400));
        splitList2.add(new Split(user1, 200));
        splitList2.add(new Split(user2, 200));

        //expenseManager.createExpense("Lunch", 600, user1, ExpenseType.EQUAL, splitList1);
        expenseManager.createExpense("Dinner", 800, user2, ExpenseType.PERCENTAGE, splitList2);
        //expenseManager.createGroupExpense("Shopping", 600, user3, group, ExpenseType.EQUAL, splitList1);

        System.out.println("Group Expenses:");
        for (Expense e : group.getExpenseList()) {
            System.out.println(e.getExpenseName() + ": " + e.getExpenseAmount());
        }
    }
}