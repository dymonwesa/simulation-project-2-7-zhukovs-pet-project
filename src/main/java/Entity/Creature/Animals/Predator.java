package Entity.Creature.Animals;

import Entity.Creature.Creature;
import Entity.Entity;
import Entity.Environment.EmptyCell;
import Position.Position;
import WorldMap.WorldMap;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class Predator extends Creature {

    @Override
    public String toCell() {
        return "🐍 ";
    }


    public void getAttack(Herbivore herbivore) {
        herbivore.minusThirtyHP();
    }

    public Herbivore findVictim(Position position, WorldMap worldMap) {
        Position[] positions = {
                new Position(position.getX(), position.getY() + 1),new Position(position.getX() + 1, position.getY() + 1),
                new Position(position.getX() + 1, position.getY()),new Position(position.getX() + 1, position.getY() - 1),
                new Position(position.getX(), position.getY() - 1),new Position(position.getX() - 1, position.getY() - 1),
                new Position(position.getX() - 1, position.getY()), new Position(position.getX() - 1, position.getY() + 1)};

        for (Position p : positions) {
            Entity entity = worldMap.getEntityAt(p);
            if(entity instanceof Herbivore){
                return (Herbivore) entity;
            }
        }
        return null;

    }


//    public Herbivore findVictim(Position position, WorldMap worldMap) {
//        for (int i = 1; i < 9; i++) {
//            switch (i) {
//                case 1:
//                    Position tempPosition = new Position(position.getX(), position.getY() + 1);
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 2:
//                    tempPosition = new Position(position.getX() + 1, position.getY() + 1);
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 3:
//                    tempPosition = new Position(position.getX() + 1, position.getY());
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 4:
//                    tempPosition = new Position(position.getX() + 1, position.getY() - 1);
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 5:
//                    tempPosition = new Position(position.getX(), position.getY() - 1);
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 6:
//                    tempPosition = new Position(position.getX() - 1, position.getY() - 1);
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 7:
//                    tempPosition = new Position(position.getX() - 1, position.getY());
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//                case 8:
//                    tempPosition = new Position(position.getX() - 1, position.getY() + 1);
//                    if (worldMap.getEntityAt(tempPosition) instanceof Herbivore) {
//                        return (Herbivore) worldMap.getEntityAt(tempPosition);
//                    }
//                    break;
//            }
//        }
//        return null;
//    }


    public void makeMove(Position position, WorldMap worldMap) {
        Predator predator = (Predator) worldMap.getEntityAt(position);
        Position nextPosition = getNextPosition(position, getNearestHerbivore(position, worldMap.getHerbivorePosition()), worldMap);
        if (!nextPosition.equals(position)) {
            worldMap.putEntityAt(nextPosition, predator);
            worldMap.putEntityAt(position, new EmptyCell());
        }
    }

    public Position getNearestHerbivore(Position predatorPosition, HashMap<Position, Herbivore> herbivorePositionMap) {
        int firstX = predatorPosition.getX();
        int firstY = predatorPosition.getY();
        int tempDistance = 10000;
        Position positionHerbivore = new Position(firstX, firstY);
        for (Map.Entry<Position, Herbivore> entry : herbivorePositionMap.entrySet()) {
            int secondX = entry.getKey().getX();
            int secondY = entry.getKey().getY();
            int distance = Math.abs((firstX - secondX) * (firstY - secondY));
            if (tempDistance > distance) {
                tempDistance = distance;
                positionHerbivore = entry.getKey();
            }
        }
        return positionHerbivore;
    }


}
