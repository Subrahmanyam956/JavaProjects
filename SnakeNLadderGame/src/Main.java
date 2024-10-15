import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
       Player player1 = new Player("Ramya", 1, 1);
       Player player2 = new Player("Subbu", 2, 1);
       int boardSize = 200;
        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(player1);
        playerQueue.add(player2);

        Dice dice = new Dice(2);

        Jumper snake1 = new Jumper(75, 32);
        Jumper snake2 = new Jumper(123, 97);
        Jumper snake3 = new Jumper(167, 88);
        List<Jumper> snakeJumpers = new ArrayList<>();
        snakeJumpers.add(snake1);
        snakeJumpers.add(snake2);
        snakeJumpers.add(snake3);

        Jumper ladder1 = new Jumper(45, 76);
        Jumper ladder2 = new Jumper(88, 143);
        Jumper ladder3 = new Jumper(126, 162);
        List<Jumper> ladderJumpers = new ArrayList<>();
        ladderJumpers.add(ladder1);
        ladderJumpers.add(ladder2);
        ladderJumpers.add(ladder3);

        Board board = new Board(playerQueue, dice, snakeJumpers, ladderJumpers, boardSize);
        board.startGame();
    }
}