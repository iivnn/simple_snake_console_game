package board;

import frame.Frame;
import frame.FrameType;
import snakeposition.Snake;

/**
 *
 * @author ivan
 */
public class Board {

    private Frame[][] board;
    public final int SIZE;

    public Board() {
        this.SIZE = 30;
        board = new Frame[this.SIZE][this.SIZE];
    }

    public void initBoard() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                board[x][y] = new Frame();
            }
        }
    }

    public void clearBoard() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y].getType().equals(FrameType.FOOD) == false) {
                    board[x][y].setType(FrameType.EMPTY);
                }

            }
        }
    }

    public void insertFood() {
        int x, y;
        do {
            x = (int) Math.abs(Math.random() * 30);
            y = (int) Math.abs(Math.random() * 30);
        } while ((board[x][y].getType()).equals(FrameType.EMPTY) == false);
        board[x][y].setType(FrameType.FOOD);
    }

    public boolean insertSnake(Snake snake) {
        boolean ate = false;
        int x, y;
        for (Frame frame : snake.getSnake()) {
            x = frame.getPosX();
            y = frame.getPosY();
            if (board[x][y].getType().equals(FrameType.FOOD)) {
                ate = true;
            }
            board[x][y].setType(frame.getType());
        }
        return ate;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public Frame[][] getBoard() {
        return board;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setBoard(Frame[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        String boardString = "";
        for (int x = 0; x < SIZE; x++) {
            boardString += "|";
            for (int y = 0; y < SIZE; y++) {
                switch (board[x][y].getType()) {
                    case EMPTY:
                        boardString += "  |";
                        break;
                    case BODY:
                        boardString += "%%|";
                        break;
                    case HEAD:
                        boardString += "@@|";
                        break;
                    case FOOD:
                        boardString += "$$|";
                        break;
                }
            }
            boardString += "\n";
        }
        return boardString ;
    }
    
}


