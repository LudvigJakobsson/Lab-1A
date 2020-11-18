import java.awt.geom.Point2D;
import java.awt.*;
import java.util.Stack;

public abstract class Trailer <T> {
    private Point2D.Double location;

    /*** Specifies the location of the trailer.
     *
     * @param location x and y coordinates for location
     */
    public void setLocation(Point2D.Double location) {
        this.location = location;
    }

    /*** Getter method for location
     *
     * @return x and y coordinates of location
     */
    public Point2D.Double getLocation() {
        return location;
    }

    /*** Getter method for ramp position
     *
     * @return current position of ramp
     */
    public abstract double getRampPosition();

    /*** Setter method for ramp position
     *
     * @param position degrees 0-70 for bed, 0-1 for car trailer 1 = open, 0 = closed.
     */
    protected abstract void setRampPosition(double position);

    /*** Getter method of trailer cargo
     *
     * @return generic stack dependent on implementation
     */
    public abstract Stack<T> getLoad();

    /*** Setter method for trailer cargo
     *
     * @param generic for cargo type
     */
    public abstract void load(T t);

    /*** Method for deloading cargo
     *
     */
    public abstract void deLoad();
}

