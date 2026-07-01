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

    private int healPoint = 50;

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

    public void minusThirtyHP() {
        this.healPoint -= 30;
    }

    public Position getNextPosition(Position p, WorldMap worldMap) {
        Random random = new Random();
        Position position = new Position(p.getX(), p.getY());
        Herbivore herbivore = (Herbivore) worldMap.getEntityAt(position);
        if (doesAnotherCellExist(worldMap, position)) {
            Position newPosition = new Position(position.getX(), position.getY());
            while (true) {
                int r = random.nextInt(4) + 1;
                switch (r) {
                    case 1 -> newPosition.setX(newPosition.getX() + 1);
                    case 2 -> newPosition.setY(newPosition.getY() + 1);
                    case 3 -> newPosition.setX(newPosition.getX() - 1);
                    case 4 -> newPosition.setY(newPosition.getY() - 1);
                }
                if (worldMap.getEntityAt(newPosition) instanceof EmptyCell || worldMap.getEntityAt(newPosition) instanceof Grass) {
                    return newPosition;
                    //worldMap.putEntityAt(newPosition, herbivore);
                //worldMap.putEntityAt(position, new EmptyCell());
                }
            }
        }
        return p;

    }

    //нужно будет добавить доп метод для return nextPos
    public void makeMove(Position position, WorldMap worldMap) {
        Position nextPosition = getNextPosition(position,worldMap);
        if (!nextPosition.equals(position)){
            if(worldMap.getEntityAt(nextPosition) instanceof Grass){
                worldMap.putEntityAt(position,new EmptyCell());
                worldMap.putEntityAt(nextPosition,this);
            } else if (worldMap.getEntityAt(nextPosition)instanceof EmptyCell)
                worldMap.putEntityAt(position,new EmptyCell());
                worldMap.putEntityAt(nextPosition,this);
                this.addTenHP();
        }
    }


    public boolean doesAnotherCellExist(WorldMap worldMap, Position position) {
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
    public String toCell() {
        return "🐇 ";
    }

}

