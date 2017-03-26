package Model.Utility;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 3/26/2017.
 */
public class LocationTest {

    Location oddCol;
    Location evenCol;

    Location oddSameLoc;
    Location evenSameLoc;

    Location oddNorth;
    Location oddNorthEast;
    Location oddNorthWest;
    Location oddSouth;
    Location oddSouthEast;
    Location oddSouthWest;

    Location evenNorth;
    Location evenNorthEast;
    Location evenNorthWest;
    Location evenSouth;
    Location evenSouthEast;
    Location evenSouthWest;

    @Before
    public void TestSetup(){
        oddCol = new Location(2, 3);
        evenCol = new Location(3, 4);

        oddSameLoc = new Location(2, 3);
        evenSameLoc = new Location(3, 4);

        oddNorth = new Location(1, 3);
        oddNorthEast = new Location(2, 4);
        oddNorthWest = new Location(2, 2);
        oddSouth = new Location(3, 3);
        oddSouthEast = new Location(3, 4);
        oddSouthWest = new Location(3, 2);

        evenNorth = new Location(2, 4);
        evenNorthEast = new Location(2, 5);
        evenNorthWest = new Location(2, 3);
        evenSouth = new Location(4, 4);
        evenSouthEast = new Location(3, 5);
        evenSouthWest = new Location(3, 3);
    }

    @Test
    public void equalsTest(){
        assertTrue(oddCol.equals(oddSameLoc));
        assertTrue(evenCol.equals(evenSameLoc));

        assertFalse(oddCol.equals(evenSameLoc));
    }

    @Test
    public void getRowColTest() {
        assertEquals(3, oddCol.getCol());
        assertEquals(2, oddCol.getRow());
    }


    @Test
    public void getAdjacentTest() {
        ArrayList<Location> oddTestLocs = oddCol.getAdjacent();
        ArrayList<Location> evenTestLocs = evenCol.getAdjacent();

        assertEquals(6, oddTestLocs.size());
        assertEquals(6, evenTestLocs.size());

        assertTrue(oddTestLocs.contains(oddNorth));
        assertTrue(oddTestLocs.contains(oddNorthEast));
        assertTrue(oddTestLocs.contains(oddNorthWest));
        assertTrue(oddTestLocs.contains(oddSouthWest));
        assertTrue(oddTestLocs.contains(oddSouthEast));
        assertTrue(oddTestLocs.contains(oddSouth));

        assertTrue(evenTestLocs.contains(evenNorth));
        assertTrue(evenTestLocs.contains(evenNorthEast));
        assertTrue(evenTestLocs.contains(evenNorthWest));
        assertTrue(evenTestLocs.contains(evenSouthWest));
        assertTrue(evenTestLocs.contains(evenSouthEast));
        assertTrue(evenTestLocs.contains(evenSouth));
    }

}