import java.awt.*;

public class MAN extends Truck{

    /***
     * Constructor for the truck type MAN
     */
    public MAN() {
        super(2, 600, Color.white, "MAN");
        setCarTrailer(10);
        stopEngine();
    }

}
