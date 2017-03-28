package Model.Utility.MapParsers;

import Model.Map.BuildMap;

/**
 * Created by jordi on 3/27/2017.
 */
public interface MapParser {
    void parseData(String builder);
    String saveMap(BuildMap map);
}
