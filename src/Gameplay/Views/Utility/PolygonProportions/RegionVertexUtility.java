/**-------------------------------------------------------------------------------------
|	RegionVertexUtility Class: Created by Alejandro Chavez on 4/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Helps out with mapping the river-rotation to an actual Vertex, which allows
|   for an Adapter between the different convention. Highly dependent on the graphical elements.
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility.PolygonProportions;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.Utility.PixelMap;
import Gameplay.Views.Utility.PolygonPointSet;
import Gameplay.Views.Utility.PolygonUtility;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.PixelPoint;
import java.util.*;


public class RegionVertexUtility {
    private static Map<String, Integer> vertexMap = new HashMap<>();
    private static GameMap map = null;

    public static HexaVertex getVertexAt(Integer river, Integer rotation, Integer regionIndex) throws Exception{
        if(river == 0){ return HexaVertex.createVertex(6); }
        //If it is a River
        if(regionIndex == 0){
            return HexaVertex.createVertex(7+rotation);
        }

        //River type 1
        if(river == 1){
            return HexaVertex.createVertex(6);
        }

        //River type 2
        if(river == 2){
            if(regionIndex == 1)
                return HexaVertex.createVertex((customMod(2+rotation,6)));
            else if(regionIndex == 2)
                return HexaVertex.createVertex(customMod(3+rotation,6));
        }

        //River type 3
        if(river == 3){
            if(regionIndex == 1)
                return HexaVertex.createVertex(customMod(2+rotation,6));
            else if(regionIndex == 2)
                return HexaVertex.createVertex(customMod(4+rotation,6));
        }

        //River type 4
        if(river == 4){
            if(regionIndex == 1)
                return HexaVertex.createVertex(customMod(2+rotation,6));
            else if(regionIndex == 2)
                return HexaVertex.createVertex(customMod(5+rotation,6));
        }

        //River type 5
        if(river == 5){
            if(regionIndex == 1)
                return HexaVertex.createVertex(customMod(2+rotation,6));
            else if(regionIndex == 2)
                return HexaVertex.createVertex(customMod(4+rotation,6));
            else if(regionIndex == 3)
                return HexaVertex.createVertex(customMod(6+rotation,6));
        }

        return null;
    }


    public static PixelPoint getRegionCenter(GameTile tile, List<HexaVertex> region){
        //Set up Map if needed
        if(map == null){
            map = GameModelFacade.getInstance().debugGetMap();
        }
        ILocation location = null; Integer river = null; Integer rotation = null;
        int regionIndex = -1;
        HexaVertex vertex = null;
        for(int i = 0; i < 4; i++){
            try {
                vertex = getVertexAt(river, rotation, regionIndex);
            }catch (Exception e){}
            if(vertex == null) continue;
            for(HexaVertex v: region){
                if(v.getValue() == vertex.getValue()){
                    regionIndex = i;
                }
            }
        }
        //Get the right PolygonPointSet for desired Region
        List<PolygonPointSet> points = PolygonUtility.getRegionsByType(river);
        PolygonPointSet pointSet = points.get(regionIndex);
        pointSet.setCurrRotation(rotation);

        //Figure out the Polygon center and adjust it to camera position
        PixelPoint origin = PixelMap.getMapTileOrigin(location);
        PixelPoint centroid = pointSet.getCentroid(origin);
        return centroid;
    }

    private static int customMod(int x, int y){
        if(x == y){
            return 6;
        }else{
            return x%y;
        }
    }
}
