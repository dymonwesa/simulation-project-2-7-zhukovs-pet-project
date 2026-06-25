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

    public void printResult(){
        worldMap.printWorldMap();
    }

    public void printSomeMove(int c){
        for (int i = 0; i < c ; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.println();
            }
            worldMap.moveHerbivores();
            worldMap.printWorldMap();
            try {
                Thread.sleep(750); // 500 миллисекунд = 0.5 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
