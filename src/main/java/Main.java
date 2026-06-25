import Simulation.Simulation;

public class Main{
    public static void main(String[] args) {
        Simulation simulation = new Simulation(25, 25);
        simulation.printResult();
        simulation.printSomeMove(40);
    }
}