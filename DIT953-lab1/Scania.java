import javax.management.RuntimeErrorException;
import java.awt.*;

public class Scania extends Truck {

    public Scania(){
        super(2, 500, Color.white, "Scania");
        stopEngine();
        setTruckBed();
    }
}
