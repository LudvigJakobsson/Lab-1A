import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;


public class ScaniaTest {

    private Scania scania;

    @Before
    public void setup() {
        scania = new Scania();
    }

    @Test
    public void testSetAngle() {
        assertEquals(0, scania.getAngle(), 0.000001);

        scania.setAngle(50);
        assertEquals(50, scania.getAngle(), 0.000001);

        scania.setAngle(100);
        assertEquals(50, scania.getAngle(), 0.000001);

        scania.gas(1);
        scania.setAngle(0);
        assertEquals(50, scania.getAngle(), 0.000001);

    }

    @Test
    public void testIncrementSpeed() {
        scania.setAngle(70);
        scania.incrementSpeed(1);
        assertEquals(0, scania.getCurrentSpeed(), 0.000001);
    }

}
