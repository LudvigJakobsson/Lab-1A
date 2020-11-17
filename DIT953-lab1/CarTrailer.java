import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.Stack;
import java.util.Iterator;

public class CarTrailer extends Trailer{
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

    public CarTrailer(int capacity, Truck truck){
        this.rampPosition = 0;
        this.capacity = capacity;
        this.truck = truck;
        this.truckConnected = true;
        setLocation(truck.getLocation());
        loadedCars = new Stack<>();
    }
    @Override
    public void setLocation(Point2D.Double location) {
        super.setLocation(location);
        Iterator<Car> iter = loadedCars.iterator();
        while (iter.hasNext()) {
            iter.next().setLocation(this.getLocation());
        }
    }

    public double getRampPosition() {
        return rampPosition;
    }

    protected void setRampPosition(double rampPosition){
        if ( rampPosition == 1 || rampPosition == 0) {
            if (truck.getCurrentSpeed() == 0 && truckConnected) {
                this.rampPosition = rampPosition;
            }else if(!truckConnected){
                this.rampPosition = rampPosition;
            }
        }else;
    }

    public void loadCar(Car car){
        if(loadedCars.size() < this.capacity && rampPosition == 1
                && getLocation().distance(car.getLocation()) <= 0.1) {
            loadedCars.push(car);
        }else;
    }

    public void deLoadCar(Car car){
        if(loadedCars.size() > 0 && rampPosition == 1) {
            loadedCars.pop();
        }else;
    }

    public Truck getTruck() {
        return truck;
    }
}


