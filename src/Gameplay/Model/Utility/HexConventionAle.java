package Gameplay.Model.Utility;

import java.util.ArrayList;

public class HexConventionAle extends RiverConvention{
    private int riverType, rotationNumber;
    private ArrayList<Integer> riverIndices;


    @Override
    public void setRivers(ArrayList<Integer> riverIndices){
        this.riverIndices = riverIndices;
        setRivers();
    }

    @Override
    public int getRiverType() {
        return riverType;

    }

    @Override
    public int getRiverRotation() {
        return rotationNumber - 1; //zero index the rotations
    }

    private void setRivers(){
        if(riverIndices.isEmpty()){
            riverType = 0;
            rotationNumber = 0;
            return;
        }

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
