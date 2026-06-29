package Entity.Creature;

import Position.Position;
import WorldMap.WorldMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    @Test
    void getNextPosition_movesTowardsAdjacentTarget() {
        // Arrange
        WorldMap worldMap = new WorldMap(10, 10);
        Position start = new Position(5, 5);
        Position target = new Position(5, 6);
        Creature creature = new Creature();

        // Act
        Position result = creature.getNextPosition(start, target, worldMap);

        // Assert
        assertEquals(target, result);
    }
}