package Entity.Environment;

import Entity.Entity;

public class EmptyCell extends Entity {
    
    @Override
    public String toCell() {
        return "..";
    }
}
