package Gameplay.Iterators;

import Gameplay.Model.Iterators.StuffIterator;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Visitors.Carriable;
import org.junit.Test;

public class TestIterators {
    @Test
    public void testDefaultImage() {
        GameModelFacade.initialize();
        GameModelFacade facade = GameModelFacade.getInstance();
        StuffIterator transporterIterator = facade.testGetTransporterIteratorDELETETHIS();
        transporterIterator.first();
        Carriable t = transporterIterator.getCurrent();
        transporterIterator.next();
        t = transporterIterator.getCurrent();
        transporterIterator.next();
        t = transporterIterator.getCurrent();
        transporterIterator.next();
        t = transporterIterator.getCurrent();
    }
}
