package Gameplay.Model.Visitors;

import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.HexaVertex;

import java.util.ArrayList;
import java.util.List;

public class RiverVisitor implements RegionMapVisitor {
    private int riverType, rotationNumber;


    @Override
    public void visitRegionMap(RegionMap regionMap) {
        List<Integer> riverIndices = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            try {
                if(regionMap.hasRegionAt(HexaVertex.createVertex(i+6))){
                    riverIndices.add(i-1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (riverIndices.isEmpty()){
            riverType = 0;
            rotationNumber = 0;
        }
        else{
            setRivers(riverIndices);
        }
    }
    public int getRiverType(){
        return riverType;
    }
    public int getRotationNumber(){
        return rotationNumber;
    }

    private void setRivers(List<Integer> riverIndices){
        int numSides = riverIndices.size();
        int startingIndex = riverIndices.get(0);

        switch (numSides){
            case 1: {
                riverType = 1;
                rotationNumber = startingIndex;
                break;
            }
            case 2: {
                int difference = riverIndices.get(1) - startingIndex;
                if(difference == 1 || difference == 5){   //Adjacent
                    riverType = 2;
                    if(difference == 5){
                        startingIndex = riverIndices.get(1);
                    }
                    rotationNumber = startingIndex;
                }
                else if(difference == 2 || difference == 4){   //Intermediate
                    riverType = 3;
                    if(difference == 4){
                        startingIndex = riverIndices.get(1);
                    }
                    if(startingIndex != 0){
                        rotationNumber = startingIndex;
                    }
                }
                else{   //Opposite
                    riverType = 4;
                    rotationNumber = startingIndex;
                }
                break;
            }
            case 3:{
                riverType = 5;
                rotationNumber = startingIndex;
                break;
            }
        }
    }
}
