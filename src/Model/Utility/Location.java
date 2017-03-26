package Model.Utility;

import java.util.ArrayList;
import java.util.List;

/**--------------------------------------------------------------------------------------
|	Location Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Temporary Shell class. Does not have concrete functionality.
---------------------------------------------------------------------------------------*/

public class Location {
    private int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public ArrayList<Location> getAdjacent(){

        ArrayList<Location> myAdj = new ArrayList<Location>();

        if(this.col % 2 == 0){
            //North
            myAdj.add(new Location(this.row + -1, this.col + 0));

            //NorthWest
            myAdj.add(new Location(this.row + -1, this.col + -1));

            //NorthEast
            myAdj.add(new Location(this.row + -1, this.col + 1));

            //South
            myAdj.add(new Location(this.row + 1, this.col + 0));

            //SouthWest
            myAdj.add(new Location(this.row + 0, this.col + -1));

            //SouthEast
            myAdj.add(new Location(this.row + 0, this.col + 1));
        }

        else{
            //North
            myAdj.add(new Location(this.row + -1, this.col + 0));

            //NorthWest
            myAdj.add(new Location(this.row + 0, this.col + -1));

            //NorthEast
            myAdj.add(new Location(this.row + 0, this.col + 1));

            //South
            myAdj.add(new Location(this.row + 1, this.col + 0));

            //SouthWest
            myAdj.add(new Location(this.row + 1, this.col + -1));

            //SouthEast
            myAdj.add(new Location(this.row + 1, this.col + 1));
        }

        return myAdj;
    }

    @Override
    public boolean equals(Object location){
        boolean equal = location instanceof Location;
        if(!equal)
            return false;

        Location myOther = (Location)location;
        return this.equals(myOther);
    }


    public boolean equals(Location location){
        return this.row == location.getRow() && this.col == location.getCol();
    }


    //TODO Maybe a directional system???
    public Location getDirection(){return null;}
}
