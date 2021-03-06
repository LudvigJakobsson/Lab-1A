import java.awt.*;
import java.awt.geom.Point2D;

/***
 *
 */
public class Vehicle implements IVehicle, Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point2D.Double location;
    private double[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int currentDirection = 0;

    /*** Creates a car with the specified attributes
     * @param nrDoors Number of doors of car
     * @param enginePower Engine power of car
     * @param color Color of car
     * @param modelName Name of car model
     */
    Vehicle (int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.location = new Point2D.Double();
    }
    public Point2D.Double getLocation(){
        return location;
    }
    public void setLocation(Point2D.Double location){
        this.location = location;
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors of the vehicle
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /*** Getter method for engine power
     *
     * @return Returns engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /*** Getter method for current speed
     *
     * @return Returns current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors
     */
    public Color getColor(){
        return color;
    }

    /*** Setter method for color of car
     *
     * @param clr color of car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /*** Starts car engine
     *
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /*** Stops car engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /*** Increases the speed of car
     * @param amount of which to increase the speed
     */
    public void incrementSpeed(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }
    }

    /*** Decreases the speed of car
     * @param amount of which to decrease the speed
     */
    public void decrementSpeed(double amount){
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
        return;
    }


    /*** Getter method for current location of car
     *
     * @return Returns cars current location
     */
    public int getCurrentDirection(){ return currentDirection;}

    /*** Method for calculating the speed factor
     *
     * @return Returns the speed factor
     */
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /*** Method for moving car in the current direction
     *
     */
    public void move() {
        location.setLocation(location.getX() + directions[currentDirection][0] * currentSpeed,
                location.getY() + directions[currentDirection][1] * currentSpeed);
    }

    /*** Method for turning the vehicle lefT
     */
    public void turnLeft() {
        --currentDirection;
        if (currentDirection < 0) {
            currentDirection = directions.length - 1;
        }
    }

    /*** Method for turning the vehicle right
     */
    public void turnRight() {
        currentDirection++;
        if (currentDirection > directions.length - 1){
            currentDirection = 0;
        }
    }

    /*** Method for increasing the speed
     *
     * @param amount of gas, restricted to values [0,1]
     */
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /*** Method for decreasing the car
     *
     * @param amount of braking restricted to values [0,1]
     */
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
