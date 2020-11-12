import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Saab95Test {
    private Saab95 saab;

    @Before
    public void setup() {
        saab = new Saab95();
    }

    @Test
    public void testMove() {
        saab.move();
        assertEquals(0, saab.getX(), 0.00001);
        assertEquals(0, saab.getY(), 0.00001);

        saab.startEngine();
        saab.move();
        assertEquals(0, saab.getX(), 0.00001);
        assertEquals(0.1, saab.getY(), 0.00001);
    }

    @Test
    public void testTurnLeft() {
        for(int i = 3; i >= 0; --i) {
            saab.turnLeft();
            assertEquals(i, saab.getCurrentDirection());
        }
    }

    @Test
    public void testTurnRight() {
        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 4:
                    saab.turnRight();
                    assertEquals(0, saab.getCurrentDirection());
                    break;
                default:
                    saab.turnRight();
                    assertEquals(i, saab.getCurrentDirection());
            }
        }
    }

    @Test
    public void testIncrementSpeed(){
        saab.incrementSpeed(2);
        assertEquals(saab.speedFactor()*2 , saab.getCurrentSpeed(), 0.000001);

        saab.setTurboOn();
        assertEquals(saab.getEnginePower() * 0.01 * 1.3 , saab.speedFactor(), 0.000001);

        saab.setTurboOff();
        assertEquals(saab.getEnginePower() * 0.01 , saab.speedFactor(), 0.000001);

    }

    @Test
    public void testDecrementSpeed(){
        saab.incrementSpeed(2);
        saab.decrementSpeed(2);
        assertEquals(0, saab.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testGetNrDoors() {
        assertEquals(2, saab.getNrDoors());
    }


}