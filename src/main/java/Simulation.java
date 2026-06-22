import java.awt.Point;
import java.util.HashMap;

public class Simulation {
    private int maxWidth;
    private int maxHeight;


    public Simulation(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public Simulation(){
        this.maxWidth = 10;
        this.maxHeight = 10;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    HashMap<Position, Creature> WorldMap = new HashMap<>();


}
