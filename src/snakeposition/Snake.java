package snakeposition;

import frame.Frame;
import frame.FrameType;
import java.util.LinkedList;

/**
 *
 * @author ivan
 */
public class Snake {

    private LinkedList<Frame> snake;
    private Direction direction;
    private LinkedList<GrowPosition> growPositionQueue;

    public Snake() {

        snake = new LinkedList<>();

        snake.add(new Frame(FrameType.HEAD, 14, 14));
        snake.add(new Frame(FrameType.BODY, 14, 13));
        snake.add(new Frame(FrameType.BODY, 14, 12));

        direction = Direction.RIGHT;

        growPositionQueue = new LinkedList<>();

    }

    public void move() {
        int nextX = 0, nextY = 0, thisX, thisY;
        for (Frame frame : snake) {
            if ((frame.getType()).equals(FrameType.BODY)) {
                thisX = frame.getPosX();
                thisY = frame.getPosY();
                frame.setPosX(nextX);
                frame.setPosY(nextY);
                nextX = thisX;
                nextY = thisY;
            } else if ((frame.getType()).equals(FrameType.HEAD)) {
                switch (this.direction) {
                    case RIGHT:
                        nextX = frame.getPosX();
                        nextY = frame.getPosY();
                        frame.setPosY(frame.getPosY() + 1);
                        break;
                    case LEFT:
                        nextX = frame.getPosX();
                        nextY = frame.getPosY();
                        frame.setPosY(frame.getPosY() - 1);
                        break;
                    case UP:
                        nextX = frame.getPosX();
                        nextY = frame.getPosY();
                        frame.setPosX(frame.getPosX() - 1);
                        break;
                    case DOWN:
                        nextX = frame.getPosX();
                        nextY = frame.getPosY();
                        frame.setPosX(frame.getPosX() + 1);
                        break;
                    default:
                        break;
                }
            }
        }
        if (growPositionQueue.isEmpty() == false) {
            if (nextX == growPositionQueue.getFirst().X && nextY == growPositionQueue.getFirst().Y) {
                Frame body = new Frame(FrameType.BODY, nextX, nextY);
                growPositionQueue.removeFirst();
                snake.add(body);
            }
        }
    }

    public void growQueue() {
        int x = snake.getFirst().getPosX();
        int y = snake.getFirst().getPosY();
        growPositionQueue.add(new GrowPosition(x, y));
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public LinkedList<Frame> getSnake() {
        return snake;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setSnake(LinkedList<Frame> snake) {
        this.snake = snake;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        switch (direction) {
            case DOWN:
                if (this.direction != Direction.UP) {
                    this.direction = direction;
                }
                break;
            case UP:
                if (this.direction != Direction.DOWN) {
                    this.direction = direction;
                }
                break;
            case LEFT:
                if (this.direction != Direction.RIGHT) {
                    this.direction = direction;
                }
                break;
            case RIGHT:
                if (this.direction != Direction.LEFT) {
                    this.direction = direction;
                }
                break;
        }
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public LinkedList<GrowPosition> getGrowPositionQueue() {
        return growPositionQueue;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setGrowPositionQueue(LinkedList<GrowPosition> growPositionQueue) {
        this.growPositionQueue = growPositionQueue;
    }

    @Override
    public String toString() {
        return "Snake{" + "snake" + snake + "\ndirection=" + direction + ", growPositionQueue=" + growPositionQueue + '}';
    }

}
