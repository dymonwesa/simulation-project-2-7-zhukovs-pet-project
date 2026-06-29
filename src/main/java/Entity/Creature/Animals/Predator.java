package Entity.Creature.Animals;

import Entity.Creature.Creature;
import Position.Position;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class Predator extends Creature {

    @Override
    public String toCell(){
        return "🐍 ";
    }



    public void getAttack(Herbivore herbivore){
        herbivore.minusThirtyHP();
    }
    public void getMove(){
    }

    public Position getNearestHerbivore(Position predatorPosition, HashMap<Position,Herbivore> herbivorePositionMap){
        int firstX = predatorPosition.getX();
        int firstY = predatorPosition.getY();
        int tempDistance = 10000;
        Position positionHerbivore = new Position(firstX,firstY);
        for(Map.Entry<Position, Herbivore> entry :herbivorePositionMap.entrySet()){
            int secondX = entry.getKey().getX();
            int secondY = entry.getKey().getY();
            int distance = Math.abs((firstX-secondX)*(firstY-secondY));
            if (tempDistance>distance){
                tempDistance = distance;
                positionHerbivore = entry.getKey();
            }
        }
        return positionHerbivore;
    }




}
