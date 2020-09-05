package snakeposition;

/**
 *
 * @author ivan
 */
public class GrowPosition {

    public final int X;
    public final int Y;

    public GrowPosition(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "GrowPosition{" + "X=" + X + ", Y=" + Y + '}';
    }

}
