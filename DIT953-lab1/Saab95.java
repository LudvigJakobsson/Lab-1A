import java.awt.*;
import java.sql.ClientInfoStatus;

public class Saab95 extends Bil implements Movable{

    private boolean turboOn = false;

    
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        stopEngine();
        String hej = "Hej Ludde";
<<<<<<< HEAD
=======
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public int getCurrentDirection(){
        return currentDirection;
>>>>>>> 05e3018c1dbf7ca261b246405da9441b1c59e335
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
