package Simulation;

import Entity.Creature;
import Entity.Entity;
import Position.Position;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Simulation {
    private int maxWidth;
    private int maxHeight;
    private int sizeOfArea;

    private LinkedHashMap<Integer, Entity> WorldMap;

    public Simulation(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.sizeOfArea = maxWidth * maxHeight;
        this.WorldMap = new LinkedHashMap<>();

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




    public void fullEmptyMap(){
        for (int i = 1; i <= sizeOfArea; i++ ){
            WorldMap
        }
    }




}
