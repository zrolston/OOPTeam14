package Gameplay.Model.Utility;

import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.TransporterFactory.LandPermit;
import Gameplay.Model.TransporterFactory.RoadPermit;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.LandTransporters.Truck;
import Gameplay.Model.Transporters.Transporter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class OwnedTest {
    Transporter t11;
    Transporter t21;
    Transporter t12;
    Transporter t22;

    PlayerID p1;
    PlayerID p2;

    @Before
    public void TestSetup(){
        p1 = new PlayerID();
        p2 = new PlayerID();

        DonkeyFactory df = new DonkeyFactory();

        t11 = df.create();
        t11.setPlayerID(p1);

        t12 = df.create();
        t12.setPlayerID(p1);

        t21 = df.create();
        t21.setPlayerID(p2);

        t22 = df.create();
        t22.setPlayerID(p2);
    }

    @Test
    public void getPlayerID() throws Exception {
        assertEquals(p1, t11.getPlayerID());
        assertEquals(p1, t12.getPlayerID());

        assertEquals(p2, t21.getPlayerID());
        assertEquals(p2, t21.getPlayerID());
    }

    @Test
    public void matches() throws Exception {
        assertTrue(t11.matches(t12));
        assertTrue(t12.matches(t11));
        assertTrue(t21.matches(t22));
        assertTrue(t22.matches(t21));

        assertFalse(t11.matches(t21));
        assertFalse(t21.matches(t11));
    }

}