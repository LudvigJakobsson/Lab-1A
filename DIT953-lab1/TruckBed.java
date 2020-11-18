import java.util.Stack;

public class TruckBed extends Trailer<Object> {
    private double position;
    private Truck truck;
    private boolean truckConnected;
    private Stack<Object> Load = new Stack<>();

    /***
     * Constructor for truck bed trailer
     * @param truck, the assigned truck
     */
    public TruckBed(Truck truck){
        this.position = 0;
        this.truck = truck;
        this.truckConnected = true;
    }

    /***
     * Getter method for ramp position
     * @return
     */
    public double getRampPosition() {
        return position;
    }

    /***
     * Getter method for the attached truck
     * @return
     */
    public Truck getTruck() {
        return truck;
    }

    /***
     * Setter method for the ramp position
     * @param position 0-70 degrees
     */
    protected void setRampPosition(double position){
        if (position >= 0 && position <= 70) {
            if (truckConnected) {
               if (truck.getCurrentSpeed() == 0) {
                   this.position = position;
               }
            } else {
                this.position = position;
            }
        }
    }


    /*** Not implemented yet
     */


    public Stack<Object> getLoad(){
        System.out.println("Not implemented yet");
        return Load;
    }

    public void load(Object o){
        System.out.println("Cannot load car in truckbed");
    }
    public void deLoad(){
        System.out.println("Cannot load car in truckbed");
    }

}
