import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.Stack;
import java.util.Iterator;

public class CarTrailer extends Trailer<Car>{
    private double rampPosition;
    private int capacity;
    private Stack<Car> loadedCars;
    private Truck truck;
    private boolean truckConnected;

    /***
     * Constructor for car trailer
     * @param capacity sets the maximum loading capacity of the car trailer.
     */
    public CarTrailer(int capacity){
        this.rampPosition = 0;
        this.capacity = capacity;
        setLocation(new Point2D.Double());
        loadedCars = new Stack<>();
    }

    /***
     * Constructor for car Trailer
     * @param capacity, maximum loading capacity of the car trailer
     * @param truck, the assigned truck
     */
    public CarTrailer(int capacity, Truck truck){
        this.rampPosition = 0;
        this.capacity = capacity;
        loadedCars = new Stack<>();
        this.truck = truck;
        this.truckConnected = true;
        setLocation(truck.getLocation());
    }

    /***
     * Sets the location of the car trailer and the loaded cars
     * @param location
     */
    @Override
    public void setLocation(Point2D.Double location) {
        super.setLocation(location);
        Iterator<Car> iter = loadedCars.iterator();
        while (iter.hasNext()) {
            iter.next().setLocation(this.getLocation());
        }
    }

    /***
     * Getter method for the ramp position
     * @return ramp position
     */
    public double getRampPosition() {
        return rampPosition;
    }

    /***
     * Setter method for ramp position
     * @param rampPosition
     */
    protected void setRampPosition(double rampPosition){
        if ( rampPosition == 1 || rampPosition == 0) {
            if (truck.getCurrentSpeed() == 0 && truckConnected) {
                this.rampPosition = rampPosition;
            }else if(!truckConnected){
                this.rampPosition = rampPosition;
            }
        }else;
    }

    /***
     * Method for loading cars on the trailer
     * @param car to be loaded
     */
    public void load(Car car){
        if(loadedCars.size() < this.capacity && rampPosition == 1
                && getLocation().distance(car.getLocation()) <= 0.1) {
            loadedCars.push(car);
        }else;
    }

    /***
     * Method for removing latest car from the trailer
     */
    public void deLoad(){
        if(loadedCars.size() > 0 && rampPosition == 1) {
            loadedCars.pop();
        }else;
    }

    /***
     * Getter method for the currently loaded cars
     * @return A stack of the loaded cars
     */
    public Stack<Car> getLoad() {
        return loadedCars;
    }

    /***
     * Getter method for the attached truck
     * @return the attached truck
     */
    public Truck getTruck() {
        return truck;
    }
}


