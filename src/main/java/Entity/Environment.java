package Entity;

public class Environment extends Entity{
    private static int environmentCounter = 0;
    private String cellView;


    public Environment() {
        this.cellView = toCell();
        environmentCounter++;
    }


    public static int getEnvironmentCounter() {
        return environmentCounter;
    }

    @Override
    public String toCell(){
        return "..";
    }

    @Override
    public String toString() {
        return "..";
    }
}





