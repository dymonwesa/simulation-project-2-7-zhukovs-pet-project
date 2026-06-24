package WorldMap;

import Entity.*;
import Entity.Creature.Animals.Herbivore;
import Entity.Creature.Animals.Predator;
import Entity.Environment.EmptyCell;
import Entity.Environment.Grass;
import Entity.Environment.Rock;
import Position.Position;

import java.util.HashMap;
import java.util.Random;

public class WorldMap {

    private HashMap<Position, Entity> worldMap;
    private int widthOfMap;
    private int heightOfMap;
    private int sizeOfMap;
    Random random = new Random();


    public WorldMap(int widthOfMap, int heightOfMap) {
        this.worldMap = new HashMap<Position, Entity>();
        this.widthOfMap = widthOfMap;
        this.heightOfMap = heightOfMap;
        this.sizeOfMap = widthOfMap * heightOfMap;
        generateRandomObjectsOnMap();
    }

    public WorldMap() {
        this.worldMap = new HashMap<Position, Entity>();
        this.widthOfMap = 25;
        this.heightOfMap = 25;
        this.sizeOfMap = 25 * 25;
        generateRandomObjectsOnMap();
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


    public void addEntity(Position position, Entity entity) {
        worldMap.put(position, entity);
    }

    public void removeEntity(Position position, Entity entity) {
        worldMap.remove(position, entity);
    }

    public String getCellOfMap(Position position) {
        return worldMap.get(position).toCell();
    }

    public void fillEmptyMap() {
        for (int columns = 1; columns <= getWidthOfMap(); columns++) {
            for (int rows = 1; rows <= getHeightOfMap(); rows++) {
                addEntity(new Position(columns, rows), new EmptyCell());
            }
        }
    }

    public void generateRandomObjectsOnMap() {
        fillEmptyMap();
        fillRandomPredatorOnMap(5);
        fillRandomHerbivoreOnMap(5);
        fillRandomGrassOnMap(10);
        fillRandomRockOnMap(7);
    }

    public void fillRandomHerbivoreOnMap(int number) {
        for (int i = 0; i < number; i++) {
            int columns = random.nextInt(1, getWidthOfMap() + 1);
            int rows = random.nextInt(1, getHeightOfMap() + 1);
            if (worldMap.get(new Position(columns, rows)) instanceof EmptyCell) {
                worldMap.put(new Position(columns, rows), new Herbivore());
            } else i--;
        }
    }

    public void fillRandomPredatorOnMap(int number) {
        for (int i = 0; i < number; i++) {
            int columns = random.nextInt(1, getWidthOfMap() + 1);
            int rows = random.nextInt(1, getHeightOfMap() + 1);
            if (worldMap.get(new Position(columns, rows)) instanceof EmptyCell) {
                worldMap.put(new Position(columns, rows), new Predator());
            } else i--;
        }
    }

    public void fillRandomGrassOnMap(int number) {
        for (int i = 0; i < number; i++) {
            int columns = random.nextInt(1, getWidthOfMap() + 1);
            int rows = random.nextInt(1, getHeightOfMap() + 1);
            if (worldMap.get(new Position(columns, rows)) instanceof EmptyCell) {
                worldMap.put(new Position(columns, rows), new Grass());
            } else i--;
        }
    }
    public void fillRandomRockOnMap(int number) {
        for (int i = 0; i < number; i++) {
            int columns = random.nextInt(1, getWidthOfMap() + 1);
            int rows = random.nextInt(1, getHeightOfMap() + 1);
            if (worldMap.get(new Position(columns, rows)) instanceof EmptyCell) {
                worldMap.put(new Position(columns, rows), new Rock());
            } else i--;
        }
    }




    public void printWorldMap() {
        for (int columns = 1; columns <= getWidthOfMap(); columns++) {
            System.out.println();
            for (int rows = 1; rows <= getHeightOfMap(); rows++) {
                Position position = new Position(columns, rows);
                System.out.print(worldMap.get(position).toCell() + " ");
            }
        }
    }

}

