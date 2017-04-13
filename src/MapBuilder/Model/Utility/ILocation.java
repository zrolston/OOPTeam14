package MapBuilder.Model.Utility;

import java.util.ArrayList;

/**
 * Created by zrgam_000 on 3/26/2017.
 */
public interface ILocation {
    int getRow();
    int getCol();

    ArrayList<ILocation> getAdjacent();

    ILocation getLocationAtIndex(HexaIndex index);
}
