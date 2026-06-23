package Entity.Environment;

import Entity.Entity;

public class Grass extends Entity {
    @Override
    public String toCell() {
        return "🌿 ";
    }
}
