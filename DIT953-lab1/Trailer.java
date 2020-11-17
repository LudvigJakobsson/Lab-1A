import java.awt.geom.Point2D;
import java.awt.*;

public abstract class Trailer {
    private double position;
    private double xPos;
    private double yPos;
    private Point2D.Double location;

    public void setLocation(Point2D.Double location) {
        this.location = location;
    }
    public Point2D.Double getLocation(){
        return location;
    }

    public abstract double getRampPosition();
    protected abstract void setRampPosition(double position);
}

