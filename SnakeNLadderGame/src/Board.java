import java.util.List;
import java.util.Queue;

public class Board {
    private Queue<Player> players;
    private Dice dice;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private int boardSize;

    public Board(Queue<Player> players, Dice dice, List<Jumper> snakes, List<Jumper> ladders, int boardSize) {
        this.players = players;
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.boardSize = boardSize;
    }

    public void startGame() {
        while(players.size() > 1) {
            Player curPlayer = this.players.peek();
            int diceRollVal = this.dice.rollDice();
            int curPlayerPosition = curPlayer.getPosition();

            int nextPosition = diceRollVal + curPlayerPosition;
            System.out.println("Player " + curPlayer.getName() + " rolled : " + diceRollVal + " is now at pos: " + curPlayerPosition );
            if(nextPosition == this.boardSize) {
                System.out.println("Player " + curPlayer.getName() + " Won the game");
                players.poll();
            } else if(nextPosition > this.boardSize) {
                players.poll();
                players.add(curPlayer);
            } else {
                int[] nextPos = new int[1];
                nextPos[0] = -1;
                snakes.forEach(snake -> {
                    if(snake.getStartPos() == nextPosition) {
                        System.out.println("Player " + curPlayer.getName() + " is bitten by snake");
                        nextPos[0] = snake.getEndPos();
                    }
                });

                ladders.forEach(ladder -> {
                    if (ladder.getStartPos() == nextPosition) {
                        System.out.println("Player "+ curPlayer.getName() + " got a ladder");
                        nextPos[0] = ladder.getEndPos();
                    }
                });
                int newPos = -1;
                if(nextPos[0] == -1) {
                    newPos = nextPosition;
                } else {
                     newPos = nextPos[0];
                }
                if(newPos == this.boardSize) {
                    System.out.println("Player "+curPlayer.getName() + " won the game");
                    players.poll();
                } else {
                    curPlayer.setPosition(newPos);
                    players.poll();
                    players.add(curPlayer);
                }
            }

        }
    }
}
