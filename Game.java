import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> players;
    public Game(int size, int snakes, int ladders) {
        initializeGame(size, snakes, ladders);
    }
    public void initializeGame(int size, int snakes, int ladders) {
        board = new Board(size, snakes, ladders);
        dice = new SixDice();
        players = new LinkedList<>();
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        players.add(p1);
        players.add(p2);
    }
    public void play() {
        Player winner = null;
        while (winner == null) {
            Player currentPlayer = getPlayer();
            System.out.println(currentPlayer.getName() + "'s turn");
            int diceRoll = dice.roll();
            int newPosition = dice.roll() + currentPlayer.getPosition();
            newPosition = jumpCheck(newPosition);
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + "'s new position: " + newPosition);
            if (newPosition > board.cells.length * (board.cells.length - 1)) {
                System.out.println("The game is over and winner is " + currentPlayer.getName());
                winner = currentPlayer;
            }
        }
    }
    private int jumpCheck(int position) {
        if(position>board.cells.length * board.cells.length - 1) {
            return position;
        }
        Cell cell = board.getCell(position);
        if(cell.jump!=null && cell.jump.getStart()==position) {
            int start = cell.jump.getStart();
            int end = cell.jump.getEnd();
            if(start>end)  System.out.println("Snake here");
            else System.out.println("Ladder here");
            return end;
        }
        return position;
    }
    private Player getPlayer() {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }
}
