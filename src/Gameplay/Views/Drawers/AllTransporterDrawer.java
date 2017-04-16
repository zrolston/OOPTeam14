package Gameplay.Views.Drawers;

import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.PlayerID;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Views.Utility.PixelPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willie on 4/16/2017.
 */
public class AllTransporterDrawer {

    public List<ImageWithLocation> getAllTransporterImages() {
        List<ImageWithLocation> images = new ArrayList<ImageWithLocation>();
        //TransporterHandler th = GameModelFacade.getInstance().getTransporterHandler();
//        TransporterDrawingVisitor tdv = new TransporterDrawingVisitor(new PixelPoint(500,500));
//        d.accept(tdv);
//        System.out.println(d.getPlayerID().getID());
//        System.out.println(tdv.getImage().image);
//        images.add(tdv.getImage());
        return images;
    }

}
