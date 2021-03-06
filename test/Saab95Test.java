import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;


public class Saab95Test {
    private Saab95 saab;

    @Before
    public void setup() {
        saab = new Saab95();
    }

    /*** Testing move() method of car
     *
     */
    @Test
    public void testMove() {
        saab.move();
        assertEquals(0, saab.getLocation().getX(), 0.00001);
        assertEquals(0, saab.getLocation().getY(), 0.00001);

        saab.startEngine();
        saab.move();
        assertEquals(0, saab.getLocation().getX(), 0.00001);
        assertEquals(0.1, saab.getLocation().getY(), 0.00001);
    }

    /*** Testing turnLeft() method of car
     *
     */
    @Test
    public void testTurnLeft() {
        for(int i = 3; i >= 0; --i) {
            saab.turnLeft();
            assertEquals(i, saab.getCurrentDirection());
        }
    }

    /*** Testing turnRight() method of car
     *
     */
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

    /*** Testing incrementSpeed() method of car
     *
     */
    @Test
    public void testIncrementSpeed(){
        saab.incrementSpeed(2);
        assertEquals(0 , saab.getCurrentSpeed(), 0.000001);

        saab.setTurboOn();
        assertEquals(saab.getEnginePower() * 0.01 * 1.3 , saab.speedFactor(), 0.000001);

        saab.setTurboOff();
        assertEquals(saab.getEnginePower() * 0.01 , saab.speedFactor(), 0.000001);

    }

    /*** Testing decrementSpeed() method of car
     *
     */
    @Test
    public void testDecrementSpeed(){
        saab.incrementSpeed(2);
        saab.decrementSpeed(2);
        assertEquals(0, saab.getCurrentSpeed(), 0.000001);
    }

    /*** Testing getNrDoors() method of car
     *
     */
    @Test
    public void testGetNrDoors() {
        assertEquals(2, saab.getNrDoors());
    }
    /*** Testing getColor() method of car
     *
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.red, saab.getColor());
    }
    /*** Testing setColor() method of car
     *
     */
    @Test
    public void testSetColor() {
        saab.setColor(Color.black);
        assertEquals(Color.black, saab.getColor());
    }
    /*** Testing gas() method of car
     *
     */
    @Test
    public void testGas() {
        saab.gas(1);
        assertEquals(saab.speedFactor(), saab.getCurrentSpeed(), 0.000001);

        saab.gas(2);
        assertEquals(saab.speedFactor(), saab.getCurrentSpeed(), 0.000001);
    }
    /*** Testing brake() method of car
     *
     */
    @Test
    public void testBrake() {
        saab.gas(1);
        saab.brake(2);
        assertEquals(saab.speedFactor(), saab.getCurrentSpeed(), 0.000001);

        saab.brake(1);
        assertEquals(0, saab.getCurrentSpeed(), 0.00001);

    }

}