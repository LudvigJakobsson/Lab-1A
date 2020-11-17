import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;


public class ScaniaTest {

    private Scania scania;
    private Trailer trailer;

    @Before
    public void setup() {
        scania = new Scania();
        trailer = scania.getTrailer();
    }

    @Test
    public void testSetRampPosition() {
        assertEquals(0, trailer.getRampPosition(), 0.000001);

        trailer.setRampPosition(50);
        assertEquals(50, trailer.getRampPosition(), 0.000001);

        trailer.setRampPosition(100);
        assertEquals(50, trailer.getRampPosition(), 0.000001);

        trailer.setRampPosition(0);
        scania.gas(1);
        trailer.setRampPosition(50);
        assertEquals(0, trailer.getRampPosition(), 0.000001);

    }

    @Test
    public void testIncrementSpeed() {
        trailer.setRampPosition(50);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed(), 0.000001);
    }

}
