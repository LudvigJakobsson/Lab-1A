import java.awt.*;
import java.sql.ClientInfoStatus;

public class Saab95 extends Bil implements Movable{

    private boolean turboOn = false;
    private double x = 0;
    private double y = 0;
    private double[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int currentDirection = 0;
    
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        stopEngine();
        String hej = "Hej Ludde";
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public int getCurrentDirection(){
        return currentDirection;
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
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void move() {
        x = x + directions[currentDirection][0] * currentSpeed;
        y = y + directions[currentDirection][1] * currentSpeed;
    }
    public void turnLeft() {
        --currentDirection;
        if (currentDirection < 0) {
            currentDirection = directions.length - 1;
        }
    }

    public void turnRight() {
        currentDirection++;
        if (currentDirection > directions.length - 1){
            currentDirection = 0;
        }
    }

    // TODO fix this method according to lab pm
    //public void gas(double amount){
    //    incrementSpeed(amount);
    //}

    // TODO fix this method according to lab pm
    //public void brake(double amount){
    //    decrementSpeed(amount);
    //}

}
