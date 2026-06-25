package Entity.Creature.Animals;

import Entity.Creature.*;
import Entity.Environment.EmptyCell;
import Position.Position;

import java.util.Map;

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


    public void addTenHP(){
        this.healPoint += 10;
    }

    void makeMove(Map.Entry<Position ,Herbivore> entry){

    }



    @Override
    public String toCell(){
        return "🐇 ";
    }

}
