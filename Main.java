import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        int size = Integer.valueOf(numbers[0]);
        int snakes = Integer.valueOf(numbers[1]);
        int ladders = Integer.valueOf(numbers[2]);
        Game game = new Game(size,snakes,ladders);
        game.play();
    }
}