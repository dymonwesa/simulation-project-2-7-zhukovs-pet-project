package Entity.Creature.Animals;

import Entity.Creature.*;
import Entity.Entity;
import Entity.Environment.EmptyCell;
import Entity.Environment.Grass;
import Position.Position;
import WorldMap.WorldMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Herbivore extends Creature {

    private int healPoint;

    @Override
    public int getHealPoint() {
        return healPoint;
    }

    @Override
    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }


    public void addTenHP() {
        this.healPoint += 10;
    }

    public void makeMove(WorldMap worldMap, Position p) {
        Random random = new Random();
        Position position = new Position(p.getX(),p.getY());
        Herbivore herbivore = (Herbivore) worldMap.getEntityAt(position);
        if (doesAnotherCellExist(worldMap, position)) {
            Position newPosition = new Position(position.getX(), position.getY());
            worldMap.putEntityAt(position, new EmptyCell());
            boolean running = true;
            while (running) {
                int r = random.nextInt(4) + 1;
                switch (r) {
                    case 1 -> newPosition.setX(newPosition.getX() + 1);
                    case 2 -> newPosition.setY(newPosition.getY() + 1);
                    case 3 -> newPosition.setX(newPosition.getX() - 1);
                    case 4 -> newPosition.setY(newPosition.getY() - 1);
                }
                if (worldMap.getEntityAt(newPosition) instanceof EmptyCell) {
                    worldMap.putEntityAt(newPosition, herbivore);
                    running = false;
                } else if (worldMap.getEntityAt(newPosition) instanceof Grass) {
                    worldMap.putEntityAt(newPosition, herbivore);
                    herbivore.addTenHP();
                    running = false;
                    //System.out.println("Herbivore ate grass at " + newPosition.getX() + ", " + newPosition.getY());
                } else {
                    newPosition.setX(position.getX());
                    newPosition.setY(position.getY());
                }
            }
        }
        }


    public boolean doesAnotherCellExist (WorldMap worldMap, Position position){
        for (int i = 0; i < 4; i++) {
            Position newPosition = new Position(position.getX(), position.getY());
            switch (i) {
                case 0 -> newPosition.setX(newPosition.getX() + 1);
                case 1 -> newPosition.setX(newPosition.getX() - 1);
                case 2 -> newPosition.setY(newPosition.getY() + 1);
                case 3 -> newPosition.setY(newPosition.getY() - 1);
            }
            if (worldMap.getEntityAt(newPosition) instanceof EmptyCell || worldMap.getEntityAt(newPosition) instanceof Grass) {
                return true;
            }
        }
        return false;
    }


        @Override
        public String toCell () {
            return "🐇 ";
        }

    }

