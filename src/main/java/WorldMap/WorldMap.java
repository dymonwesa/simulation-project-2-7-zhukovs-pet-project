package WorldMap;

import Entity.*;
import Entity.Environment.EmptyCell;
import Position.Position;

import java.util.HashMap;
import java.util.Random;

public class WorldMap {

    private HashMap<Position, Entity> worldMap;
    private int widthOfMap;
    private int heightOfMap;
    private int sizeOfMap;



    public WorldMap(int widthOfMap, int heightOfMap) {
        this.worldMap = new HashMap<Position, Entity>();
        this.widthOfMap = widthOfMap;
        this.heightOfMap = heightOfMap;
        this.sizeOfMap = widthOfMap * heightOfMap;
        fillEmptyMap();

    }

    public WorldMap() {
        this.worldMap = new HashMap<Position, Entity>();
        this.widthOfMap = 25;
        this.heightOfMap = 25;
        this.sizeOfMap = 25*25;
        fillEmptyMap();
    }

    public int getWidthOfMap() {
        return widthOfMap;
    }

    public int getHeightOfMap() {
        return heightOfMap;
    }

    public int getSizeOfMap() {
        return sizeOfMap;
    }



    public void addEntity(Position position, Entity entity){
        worldMap.put(position,entity);
    }

    public void removeEntity(Position position, Entity entity){
        worldMap.remove(position, entity);
    }

    public String getCellOfMap(Position position){
        return worldMap.get(position).toCell();
    }

    public void fillEmptyMap(){
        for (int columns = 1; columns <=getWidthOfMap(); columns++){
            for (int rows = 1;rows<=getHeightOfMap();rows++){
                addEntity(new Position(columns,rows),new EmptyCell());
            }
        }
    }

    public void printWorldMap(){
        for (int columns = 1; columns <=getWidthOfMap(); columns++){
            System.out.println();
            for (int rows = 1;rows<=getHeightOfMap();rows++){
                Position position = new Position(columns, rows);
                System.out.print(worldMap.get(position).toCell() + " ");
            }
        }
    }

}

