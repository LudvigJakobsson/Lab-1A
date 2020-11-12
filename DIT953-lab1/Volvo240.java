import java.awt.*;

public class Volvo240 extends Bil implements Movable{

    private final static double trimFactor = 1.25;

    /*** constructor of Volov 240 calling car constructor.
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }

    /*** Implimentation of car speedfactor
     * @return Returns speedfactor of saab95
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
