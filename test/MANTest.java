import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.awt.geom.Point2D;

public class MANTest {
    private MAN manTruck;
    private Car volvo;
    private Trailer trailer;

    @Before
    public void setup() {
        manTruck = new MAN();
        trailer = manTruck.getTrailer();
        volvo = new Volvo240();
    }

    @Test
    public void testSetColor() {
        manTruck.setColor(Color.blue);
        assertEquals(Color.blue, manTruck.getColor());
    }

    @Test
    public void testSetRampPosition() {
        trailer.setRampPosition(1);
        assertEquals(1,trailer.getRampPosition(), 0.000001);

        trailer.setRampPosition(0);
        manTruck.gas(1);
        trailer.setRampPosition(1);
        assertEquals(0,trailer.getRampPosition(), 0.000001);

    }
    @Test
    public void testGas() {
        trailer.setRampPosition(1);
        manTruck.gas(1);
        assertEquals(0, manTruck.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testLoad() {
        trailer.setRampPosition(1);

        volvo.setLocation(new Point2D.Double(1,1));
        trailer.load(volvo);
        assertEquals(0, trailer.getLoad().size());

        volvo.setLocation(manTruck.getLocation());
        trailer.load(volvo);
        assertEquals(1, trailer.getLoad().size());

        trailer.deLoad();
        assertEquals(0, trailer.getLoad().size());

    }

}
