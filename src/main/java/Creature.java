public class Creature extends Entity {
    private int healPoint;
    private int speed;


    public Creature() {
        healPoint = 100;
        speed = 0;
    }

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

    String toCell(){
        return " ";
    }
}
