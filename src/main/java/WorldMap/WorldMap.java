package WorldMap;

import Entity.*;
import Position.Position;

import java.util.HashMap;
import java.util.Random;

public class WorldMap {

    private HashMap<Position, Entity> worldMap;
    private int widthOfMap;
    private int heightOfMap;
    private int va



    public WorldMap(int widthOfMap, int heightOfMap) {
        this.worldMap = new HashMap<Position, Entity>();
        this.widthOfMap = widthOfMap;
        this.heightOfMap = heightOfMap;
    }

    public WorldMap() {
        this.worldMap = new HashMap<Position, Entity>();
        this.widthOfMap = 25;
        this.heightOfMap = 25;
    }

    public  void addEntity(Position position, Entity entity){
        worldMap.put(position,entity);
    }

    public void removeEntity(Position position, Entity entity){
        worldMap.remove(position, entity);
    }

    public String getCellOfMap(Position position){
        return worldMap.get(position).toCell();
    }










    //-----------------------edit

}

