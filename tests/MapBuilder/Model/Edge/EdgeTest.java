package MapBuilder.Model.Edge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by zrgam_000 on 3/26/2017.
 */
public class EdgeTest {

    Edge sea;
    Edge river;
    Edge land;

    Edge sea2;
    Edge river2;
    Edge land2;

    @Before
    public void TestSetup(){
        sea = new SeaEdge();
        river = new RiverEdge();
        land = new LandEdge();

        sea2 = new SeaEdge();
        river2 = new RiverEdge();
        land2 = new LandEdge();
    }

    @Test
    public void SeaMatchTest(){
        assertTrue(sea.matchesWith(sea2));
        assertTrue(sea.matchesWith(land));
        assertTrue(sea.matchesWith(river));
    }

    @Test
    public void RiverMatchTest(){
        assertTrue(river.matchesWith(sea));
        assertFalse(river.matchesWith(land));
        assertTrue(river.matchesWith(river2));
    }

    @Test
    public void LandMatchTest(){
        assertTrue(land.matchesWith(sea));
        assertFalse(land.matchesWith(river));
        assertTrue(land.matchesWith(land2));
    }
}