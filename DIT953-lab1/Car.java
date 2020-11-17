import java.awt.*;
import java.awt.geom.Point2D;

/***
 *
 */
public class Car implements IVehicle, Movable {
    private double currentSpeed;
    private Vehicle parent;


    /*** Creates a car with the specified attributes
     * @param nrDoors Number of doors of car
     * @param enginePower Engine power of car
     * @param color Color of car
     * @param modelName Name of car model
     */
    Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.parent = new Vehicle(nrDoors, enginePower, color, modelName);
    }
    public double getEnginePower() {
        return parent.getEnginePower();
    }

    /*** Getter method for current speed
     *
     * @return Returns current speed
     */
    public double getCurrentSpeed(){
        return parent.getCurrentSpeed();
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors
     */
    public int getNrDoors(){
        return parent.getNrDoors();
    }
    public Color getColor(){
        return parent.getColor();
    }

    /*** Setter method for color of car
     *
     * @param clr color of car
     */
    public void setColor(Color clr){
        parent.setColor(clr);
    }

    /*** Starts car engine
     *
     */
    public void startEngine(){
        parent.startEngine();
    }

    /*** Stops car engine
     */
    public void stopEngine(){
        parent.stopEngine();
    }

    /*** Increases the speed of car
     * @param amount of which to increase the speed
     */
    @Override
    public void incrementSpeed(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.max(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }
    }

    /*** Decreases the speed of car
     * @param amount of which to decrease the speed
     */
    public void decrementSpeed(double amount){
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
    }

    /*** Getter method for x coordinate
     * @return Returns x coordinate
     */

    public Point2D.Double getLocation(){
        return parent.getLocation();
    }

    public void setLocation(Point2D.Double location) {
        parent.setLocation(location);
    }

    /*** Getter method for current location of car
     *
     * @return Returns cars current location
     */
    public int getCurrentDirection(){
        return parent.getCurrentDirection();
    }

    /*** Method for calculating the speed factor
     *
     * @return Returns the speed factor
     */
    public double speedFactor(){
        return parent.speedFactor();
    }

    /*** Method for moving car in the current direction
     *
     */
    public void move(){
        parent.move();
    }

    /*** Method for turning the vehicle lefT
     */
    public void turnLeft(){
        parent.turnLeft();
    }

    /*** Method for turning the vehicle right
     */
    public void turnRight(){
        parent.turnRight();
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

