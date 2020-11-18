import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
public class WorkshopTest {
    private Workshop<Car> genWorkshop;
    private Workshop <Saab95> brandWorkshop;

    public void addNr(int numberOfCars){
        for (int i=0; i < numberOfCars; i++){
            genWorkshop.add(new Volvo240());
        }
    }

    @Before
    public void setup(){
        genWorkshop = new Workshop(10);
    }

    @Test
    public void testAdd(){
        addNr(12);
        assertEquals(10, genWorkshop.getCars().size()  , 0.0000001);
    }
    @Test
    public void testRemove(){
    addNr(5);
    genWorkshop.remove(0);
        assertEquals(4, genWorkshop.getCars().size()  , 0.0000001);
    }
    @Test
    public void testGetCar(){
        Volvo240 volvo = new Volvo240();
        genWorkshop.add(volvo);
        assertEquals(volvo, genWorkshop.getCar(0));
    }

}
