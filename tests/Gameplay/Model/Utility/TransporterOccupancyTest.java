package Gameplay.Model.Utility;

import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.SeaRegion;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.Transporters.Transporter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public class TransporterOccupancyTest {
    TransporterOccupancy to1;
    TransporterOccupancy to2;

    Transporter t11;
    Transporter t12;
    Transporter t21;
    Transporter t22;

    PlayerID p1;
    PlayerID p2;

    @Before
    public void TestSetup(){

        DonkeyFactory df = new DonkeyFactory();

        p1 = PlayerID.getPlayer1ID();
        p2 = PlayerID.getPlayer2ID();

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
    public void TestPlace(){

        to1 = new TransporterOccupancy(new LandRegion());
        to2 = new TransporterOccupancy(new SeaRegion());

        assertTrue(to1.isEmpty());
        assertTrue(to2.isEmpty());

        assertEquals(0, to1.getSize());
        assertEquals(0, to2.getSize());

        to1.add(t11);
        to1.add(t12);
        to1.add(t21);

        to2.add(t22);

        assertFalse(to1.isEmpty());
        assertFalse(to2.isEmpty());

        assertEquals(3, to1.getSize());
        assertEquals(1, to2.getSize());

        assertEquals(3, to1.getTransporters().size());
        assertEquals(1, to2.getTransporters().size());

        assertEquals(2, to1.getOwnedTransporters(t11).size());
        assertEquals(1, to1.getOwnedTransporters(t21).size());
        assertEquals(1, to2.getOwnedTransporters(t21).size());
        assertEquals(0, to2.getOwnedTransporters(t11).size());
    }

    @Test
    public void testRemove(){

        to1 = new TransporterOccupancy(new LandRegion());
        to2 = new TransporterOccupancy(new SeaRegion());

        to1.add(t11);
        to1.add(t12);
        to1.add(t21);

        to2.add(t22);

        assertEquals(3, to1.getTransporters().size());
        assertEquals(1, to2.getTransporters().size());

        assertEquals(2, to1.getOwnedTransporters(t11).size());
        assertEquals(1, to1.getOwnedTransporters(t21).size());
        assertEquals(1, to2.getOwnedTransporters(t21).size());
        assertEquals(0, to2.getOwnedTransporters(t11).size());

        to1.remove(t12);
        to1.remove(t21);

        assertEquals(1, to1.getTransporters().size());
        assertEquals(1, to2.getTransporters().size());

        assertEquals(1, to1.getOwnedTransporters(t11).size());
        assertEquals(0, to1.getOwnedTransporters(t21).size());
        assertEquals(1, to2.getOwnedTransporters(t21).size());
        assertEquals(0, to2.getOwnedTransporters(t11).size());

        to2.remove(t22);

        assertFalse(to1.isEmpty());
        assertTrue(to2.isEmpty());

    }
}