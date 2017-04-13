package MapBuilder.Model.Utility.MapParsers;

import MapBuilder.Model.Map.BuildMap;

/**
 * Created by jordi on 3/27/2017.
 */
public interface MapParser {
    void parseData(String builder);
    void saveMap(BuildMap map, String path);
}
