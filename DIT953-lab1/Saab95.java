import java.awt.*;
import java.sql.ClientInfoStatus;


public class Saab95 extends Car implements Movable{

    private boolean turboOn = false;

    /*** Constructor of saab95 calling car constructor.
     *
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        stopEngine();
    }

    /*** Setter method for turning on turbo
     *
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /*** Setter method for turning off turbo
     *
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /*** Implimentation of car speedfactor
     * @return Returns speedfactor of saab95
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
