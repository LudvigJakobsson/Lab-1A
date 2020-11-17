import java.util.ArrayList;
import java.util.Arrays;

public class BrandWorkshop<T extends Car> {
    private int capacity;
    ArrayList<T> Cars;

    public BrandWorkshop(int capacity) {
        this.Cars = new ArrayList<>(capacity);
    }


}

