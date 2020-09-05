package frame;

/**
 *
 * @author ivan
 */
public class Frame {

    private FrameType type;
    private int posX;
    private int posY;
    public final int MAX_VALUE = 29;
    public final int MIN_VALUE = 0;

    public Frame() {
        this.type = FrameType.EMPTY;
    }

    public Frame(FrameType type, int posX, int posY) {
        this.type = type;
        this.posX = posX;
        this.posY = posY;
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Frame(int posX, int posY) {
        this.setPosX(posX);
        this.setPosY(posY);
    }

    public FrameType getType() {
        return type;
    }

    public void setType(FrameType type) {
        this.type = type;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        if (posX > MAX_VALUE) {
            this.posX = MIN_VALUE;
        } else if (posX < MIN_VALUE) {
            this.posX = MAX_VALUE;
        } else {
            this.posX = posX;
        }
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        if (posY > MAX_VALUE) {
            this.posY = MIN_VALUE;
        } else if (posY < MIN_VALUE) {
            this.posY = MAX_VALUE;
        } else {
            this.posY = posY;
        }

    }

    @Override
    public String toString() {
        return "\nFrame{" + "type=" + type + ", posX=" + posX + ", posY="
                + posY + ", MAX_VALUE=" + MAX_VALUE + ", MIN_VALUE=" + MIN_VALUE + "}";
    }

    public String toStringMove() {
        return "position [posX=" + posX + ", posY=" + posY + "]";
    }

}
