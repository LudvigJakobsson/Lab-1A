import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

public class Volvo240Test {
    private Volvo240 volvo;

    @Before
    public void setup() {
        volvo = new Volvo240();
    }

    /***
     * Testing move() method of car
     */
    @Test
    public void testMove() {
        volvo.move();
        assertEquals(0, volvo.getLocation().getX(), 0.00001);
        assertEquals(0, volvo.getLocation().getY(), 0.00001);

        volvo.startEngine();
        volvo.move();
        assertEquals(0, volvo.getLocation().getX(), 0.00001);
        assertEquals(0.1, volvo.getLocation().getY(), 0.00001);
    }

    /***
     * Testing turnLeft() method of car
     */
    @Test
    public void testTurnLeft() {
        for(int i = 3; i >= 0; --i) {
            volvo.turnLeft();
            assertEquals(i, volvo.getCurrentDirection());
        }
    }

    /***
     * Testing turnRight() method of car
     */
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

    /***
     * Testing incrementSpeed() method of car
     */
    @Test
    public void testIncrementSpeed(){
        volvo.incrementSpeed(10000);
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed(), 0.000001);
    }

    /***
     * Testing decrementSpeed() method of car
     */
    @Test
    public void testDecrementSpeed(){
        volvo.decrementSpeed(2);
        assertEquals(0, volvo.getCurrentSpeed(), 0.000001);
    }

    /***
     * Testing getNrDoors() method of car
     */
    @Test
    public void testGetNrDoors() {
        assertEquals(4, volvo.getNrDoors());
    }
    /*** Testing getColor() method of car
     *
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.black, volvo.getColor());
    }
    /*** Testing setColor() method of car
     *
     */
    @Test
    public void testSetColor() {
        volvo.setColor(Color.red);
        assertEquals(Color.red, volvo.getColor());
    }
    /*** Testing gas() method of car
     *
     */
    @Test
    public void testGas() {
        volvo.gas(1);
        assertEquals(volvo.speedFactor(), volvo.getCurrentSpeed(), 0.000001);

        volvo.gas(2);
        assertEquals(volvo.speedFactor(), volvo.getCurrentSpeed(), 0.000001);
    }
    /*** Testing brake() method of car
     *
     */
    @Test
    public void testBrake() {
        volvo.gas(1);
        volvo.brake(2);
        assertEquals(volvo.speedFactor(), volvo.getCurrentSpeed(), 0.000001);

        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0.00001);

    }

}
