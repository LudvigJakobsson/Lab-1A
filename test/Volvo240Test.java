import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Volvo240Test {
    private Volvo240 volvo;

    @Before
    public void setup() {
        volvo = new Volvo240();
    }

    @Test
    public void testMove() {
        volvo.move();
        assertEquals(0, volvo.getX(), 0.00001);
        assertEquals(0, volvo.getY(), 0.00001);

        volvo.startEngine();
        volvo.move();
        assertEquals(0, volvo.getX(), 0.00001);
        assertEquals(0.1, volvo.getY(), 0.00001);
    }

    @Test
    public void testTurnLeft() {
        for(int i = 3; i >= 0; --i) {
            volvo.turnLeft();
            assertEquals(i, volvo.getCurrentDirection());
        }
    }

    @Test
    public void testTurnRight() {
        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 4:
                    volvo.turnRight();
                    assertEquals(0, volvo.getCurrentDirection());
                    break;
                default:
                    volvo.turnRight();
                    assertEquals(i, volvo.getCurrentDirection());
            }

        }
    }

    @Test
    public void testIncrementSpeed(){
        volvo.incrementSpeed(2);
        assertEquals(volvo.speedFactor()*2 , volvo.getCurrentSpeed(), 0.000001);

        volvo.incrementSpeed(10000);
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed(), 0.000001);
    }
    @Test
    public void testDecrementSpeed(){
        volvo.decrementSpeed(2);
        assertEquals(0, volvo.getCurrentSpeed(), 0.000001);
    }

}
