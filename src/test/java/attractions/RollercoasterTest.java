package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {

        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(11,210, 100);
        visitor2 = new Visitor(15, 120, 100);
        visitor3 = new Visitor(15,150, 100);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() { assertEquals(0, rollerCoaster.getVisitCount()); }

    @Test
    public void deniesAccessIfUnder13(){ assertEquals(false, rollerCoaster.isAllowedTo(visitor));}

    @Test
    public void deniesAccessIfTooShort(){ assertEquals(false, rollerCoaster.isAllowedTo(visitor2));}

    @Test
    public void allowsAccessIfOver12AndTall(){ assertEquals(true, rollerCoaster.isAllowedTo(visitor3));}

    @Test
    public void chargesUnderHeight200Default(){ assertEquals(8.40, rollerCoaster.priceFor(visitor3), 0.001);}

    @Test
    public void chargesOverHeight200Double(){ assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.001);}
}
