package WorldMap;

import Entity.*;
import Position.Position;

import java.util.HashMap;
import java.util.Random;

public class WorldMap {

    private HashMap<Position, Entity> worldMap;
    private int widthOfMap;
    private int heightOfMap;


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








    //-----------------------edit
    public void fullEmptyMap(){
        for (int i = 1; i <= sizeOfArea; i++ ){
            WorldMap.put(i, new Environment());
        }
    }
    public void putRandomHerbivore(){
        Random random = new Random();
        for (int i = 0; i < sizeOfArea / 70; i++){
            int rNumber = random.nextInt(sizeOfArea);
            WorldMap.put(rNumber, new Herbivore());
        }
    }

    public void putRandomPredator(){
        Random random = new Random();
        for (int i = 0; i < sizeOfArea / 70; i++){
            int rNumber = random.nextInt(sizeOfArea);
            WorldMap.put(rNumber, new Predator());
        }
    }

    public void generateRandomWorldMap(){
        fullEmptyMap();
        putRandomHerbivore();
        putRandomPredator();
    }

    public void printMap(){
        for(int i = 1; i <= sizeOfArea; i++){
            if (i % maxWidth == 1){
                System.out.println();
            }
            System.out.print(WorldMap.get(i).toCell() + " ");
        }
    }
}

