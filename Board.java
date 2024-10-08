import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    private int size;
    public Board(int size, int snakes, int ladders) {
        this.size = size;
        cells = new Cell[size][size];
        initialize(size);
        addJumps(snakes, ladders, cells);

    }
    public void initialize(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

   public void addJumps(int snakes, int ladders, Cell[][] cells){
        while(snakes>0){
            int start = ThreadLocalRandom.current().nextInt(1, size*size-1);
            int end = ThreadLocalRandom.current().nextInt(1, size*size-1);
            if(start<end){
                int temp = start;
                start = end;
                end = temp;
            }
            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;
            snakes--;
        }
       while(ladders>0){
           int start = ThreadLocalRandom.current().nextInt(1, size*size-1);
           int end = ThreadLocalRandom.current().nextInt(1, size*size-1);
           if(start>end){
               int temp = start;
               start = end;
               end = temp;
           }
           Jump jump = new Jump(start, end);
           Cell cell = getCell(start);
           cell.jump = jump;
           ladders--;
       }
   }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }

}
