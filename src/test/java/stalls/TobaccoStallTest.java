package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        visitor = new Visitor(15, 1.5, 100);
        visitor2 = new Visitor(21, 1.5, 100);
    }

    @Test
    public void canGetRating(){ assertEquals(5, tobaccoStall.getRating());}

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void allowsAccessToOver18s() { assertEquals(true, tobaccoStall.isAllowedTo(visitor2));}

    @Test
    public void deniesAccessToUnder18s() { assertEquals(false, tobaccoStall.isAllowedTo(visitor));}
}
