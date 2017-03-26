package Model.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zrgam_000 on 3/26/2017.
 */
public interface ILocation {
    public int getRow();
    public int getCol();

    public ArrayList<ILocation> getAdjacent();
}
