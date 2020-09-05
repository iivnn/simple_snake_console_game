package control;

import board.Board;
import frame.Frame;
import frame.FrameType;
import snakeposition.Snake;

/**
 *
 * @author ivan
 */
public class GameController implements Runnable {

    private Board board;
    private Snake snake;
    private boolean running;

    public GameController() {
        running = false;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void newGame() {
        this.running = false;
        board = new Board();
        snake = new Snake();
        board.initBoard();
        board.insertSnake(snake);
        board.insertFood();
    }

    public void startGame() {
        if (this.running == false && !(board == null)) {
            running = true;
            move();
        }
    }

    @SuppressWarnings("InfiniteRecursion")
    public void move() {
        if (this.isRunning()) {
            snake.move();
            board.clearBoard();
            boolean ate = board.insertSnake(snake);
            if (ate) {
                snake.growQueue();
                board.insertFood();
            }
            System.out.println(board.toString());
            running = !lost();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                running = false;
                System.err.println("erro : " + ex);
            }
            move();
        }

    }

    private boolean lost() {
        boolean lose = false;
        Frame head = snake.getSnake().getFirst();
        for (Frame frame : snake.getSnake()) {
            if ((frame.getType()).equals(FrameType.HEAD) == false) {
                if (head.getPosX() == frame.getPosX() && head.getPosY() == frame.getPosY()) {
                    System.out.println("You died!");
                    newGame();
                    lose = true;
                }
            }
        }
        return lose;
    }

    @Override
    public String toString() {
        return "GameController{" + "board=\n" + board + ", snake=" + snake + ", running=" + running + '}';
    }

    @Override
    public void run() {
        this.startGame();
    }

}
