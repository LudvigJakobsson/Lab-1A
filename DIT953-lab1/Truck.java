import java.awt.*;

public class Truck implements IVehicle, Movable {
    private Vehicle parent;
    private Trailer trailer;
    private boolean hasTrailer;

    Truck(int nrDoors, double enginePower, Color color, String modelName) {
        this.parent = new Vehicle(nrDoors, enginePower, color, modelName);
    }

    /*** Getter method for number of doors
     *
     * @return Returns number of doors of the vehicle
     */
    public int getNrDoors(){
        return parent.getNrDoors();
    }

    /*** Getter method for engine power
     *
     * @return Returns engine power
     */
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
    public void startEngine() {
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
    public void incrementSpeed(double amount) {
        if (hasTrailer == false) {
            parent.incrementSpeed(amount);
        }
        else if(trailer.getPosition() == 0){
            parent.incrementSpeed(amount);
        }
    }


    /*** Decreases the speed of car
     * @param amount of which to decrease the speed
     */
    public void decrementSpeed(double amount) {
        parent.decrementSpeed(amount);
    }

    /*** Getter method for x coordinate
     * @return Returns x coordinate
     */
    public double getX(){
        return parent.getX();
    }


    /*** Getter method for y coordinate
     *
     * @return Returns y coordinate
     */
    public double getY(){
        return parent.getY();
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
        parent.gas(amount);
    }

    /*** Method for decreasing the car
     *
     * @param amount of braking restricted to values [0,1]
     */
    public void brake(double amount){
        parent.brake(amount);
    }

    //public void setCarTrailer(){
    //    if (hasTrailer = false) {
    //        this.trailer = new CarTrailer();
    //        hasTrailer = true;
    //    }
    //}

    public void setTruckBed() {
        if (hasTrailer = false) {
            trailer = new TruckBed();
            hasTrailer = true;
        }
    }

    public void setTrailerPosition(double position) {
        if(parent.getCurrentSpeed() == 0) {
            trailer.setPosition(position);
        }
    }

}






