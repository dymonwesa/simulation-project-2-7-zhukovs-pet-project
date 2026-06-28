package Entity.Creature;

import Entity.Entity;
import Entity.Environment.EmptyCell;
import Entity.Environment.Grass;
import Position.Position;
import WorldMap.WorldMap;

import java.io.PipedInputStream;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Creature extends Entity {
    private int healPoint;
    private int speed;
    Position position;


    public int getHealPoint() {
        return healPoint;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void makeMove() {

    }

    public Boolean isMoveable(Position position, WorldMap worldMap) {
        if (worldMap.getEntityAt(position) instanceof EmptyCell || worldMap.getEntityAt(position) instanceof Grass) {
            return true;
        }
        return false;
    }

    public Position getNextPosition(Position startPosition, Position targetPosition, WorldMap worldMap) {
        Queue<Position> queue = new LinkedList<>();
        Map<Position, Position> cameFrom = new HashMap<>();
        queue.add(startPosition);
        cameFrom.put(startPosition, null);

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.equals(targetPosition)) {

                break;
            }
            Position[] positions = new Position[4];
            positions[0] = new Position(current.getX(), current.getY() + 1);
            positions[1] = new Position(current.getX() + 1, current.getY());
            positions[2] = new Position(current.getX(), current.getY() - 1);
            positions[3] = new Position(current.getX() - 1, current.getY());
            for (int i = 0; i < 4; i++) {
                if (isMoveable(positions[i], worldMap) && !(cameFrom.containsKey(positions[i]))) {
                    cameFrom.put(positions[i], current);
                    queue.add(positions[i]);
                }
            }
        }
        if (cameFrom.containsKey(targetPosition)){
          Queue<Position> wayToStart = new LinkedList<>();
          queue.add(targetPosition);
          boolean running = true;
            Position tempPosition = targetPosition;
            while(running){
                if (cameFrom.get(tempPosition).equals(startPosition)){

                }
          }
        } else {
           return startPosition; //stand still
        }

        return null;
    }



        @Override
        public String toCell () {
            return " ";
        }
    }
