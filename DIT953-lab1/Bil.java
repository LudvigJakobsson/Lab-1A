import java.awt.*;

public abstract class Bil implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int currentDirection = 0;

    Bil (int nrDoors, double enginePower, Color color, String modelName){
        /**

         */

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){

        return enginePower;
    }

    public double getCurrentSpeed(){

        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public int getCurrentDirection(){ return currentDirection;}

    public abstract double speedFactor();

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

    public void gas(double amount){
        if (amount >= 0 || amount <= 1){
            incrementSpeed(amount);
        }
        else {
            System.out.print("hej");
            return;
        }
    }

    public void brake(double amount){
        if (amount >= 0 || amount <= 1){
            decrementSpeed(amount);
        }
        else {
            return;
        }
    }
}
