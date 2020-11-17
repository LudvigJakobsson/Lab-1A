public class TruckBed extends Trailer {
    private double position;
    private Truck truck;
    private boolean truckConnected;

    public TruckBed(Truck truck){
        this.position = 0;
        this.truck = truck;
        this.truckConnected = true;
    }

    public double getRampPosition() {
        return position;
    }

    public Truck getTruck() {
        return truck;
    }

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

}
