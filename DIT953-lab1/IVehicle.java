import java.awt.*;
import java.awt.geom.Point2D;

public interface IVehicle {
    public int getNrDoors();

    /*** Getter method for engine power
     *
     * @return Returns engine power
     */
    double getEnginePower();

    /*** Getter method for current speed
     *
     * @return Returns current speed
     */
    double getCurrentSpeed();

    /*** Getter method for number of doors
     *
     * @return Returns number of doors
     */
    Color getColor();

    /*** Setter method for color of car
     *
     * @param clr color of car
     */
    void setColor(Color clr);

    /*** Starts car engine
     *
     */
    void startEngine();

    /*** Stops car engine
     */
    void stopEngine();

    /*** Increases the speed of car
     * @param amount of which to increase the speed
     */
    void incrementSpeed(double amount);

    /*** Decreases the speed of car
     * @param amount of which to decrease the speed
     */
    void decrementSpeed(double amount);

    /*** Getter method for current location of car
     *
     * @return Returns cars current location
     */
    int getCurrentDirection();

    /*** Method for calculating the speed factor
     *
     * @return Returns the speed factor
     */
    double speedFactor();

    Point2D.Double getLocation();

    /*** Method for moving car in the current direction
     *
     */
    void move();

    /*** Method for turning the vehicle lefT
     */
    void turnLeft();

    /*** Method for turning the vehicle right
     */
    void turnRight();

    /*** Method for increasing the speed
     *
     * @param amount of gas, restricted to values [0,1]
     */
    void gas(double amount);

    /*** Method for decreasing the car
     *
     * @param amount of braking restricted to values [0,1]
     */
    void brake(double amount);

}
