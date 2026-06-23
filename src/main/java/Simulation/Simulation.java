package Simulation;

import WorldMap.WorldMap;

public class Simulation {
    WorldMap worldMap;

    public Simulation(int widthOfMap, int heightOfMap) {
        this.worldMap = new WorldMap(widthOfMap, heightOfMap);
    }

    public Simulation() {
        this.worldMap = new WorldMap();
    }


}
