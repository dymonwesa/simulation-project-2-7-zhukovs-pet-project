package Entity.Creature;

import Entity.Entity;
import Entity.Environment.EmptyCell;
import Entity.Environment.Grass;
import Position.Position;
import WorldMap.WorldMap;

public class Creature extends Entity {
    private int healPoint;
    private int speed;



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

    void makeMove(){

    }

    @Override
    public String toCell(){
        return " ";
    }
}
