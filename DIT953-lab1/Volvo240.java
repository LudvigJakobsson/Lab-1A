import java.awt.*;

public class Volvo240 extends Bil implements Movable{

    private final static double trimFactor = 1.25;
    private double x;
    private double y;
    private double[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int currentDirection = 0;
    
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public int getCurrentDirection(){ return currentDirection;}

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

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
   // public void gas(double amount){
   //     incrementSpeed(amount);
   // }

    // TODO fix this method according to lab pm
    //public void brake(double amount){
    //    decrementSpeed(amount);
    //}
}
