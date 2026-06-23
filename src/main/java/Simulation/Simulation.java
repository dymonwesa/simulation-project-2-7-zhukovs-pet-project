package Simulation;

import Entity.Creature;
import Entity.Entity;
import Position.Position;
import Entity.Environment;
import Entity.*;
import WorldMap.WorldMap;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class Simulation {
    WorldMap worldMap;

    public Simulation(int widthOfMap, int heightOfMap) {
        this.worldMap = new WorldMap(widthOfMap, heightOfMap);
    }

    public Simulation() {
        this.worldMap = new WorldMap();
    }


}
