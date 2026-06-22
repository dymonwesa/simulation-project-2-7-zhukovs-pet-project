package Entity;

public abstract class Entity {
    private static int entityCounter = 0;

    public Entity() {
        entityCounter++;
    }

    public abstract String toCell();




}
