package Model.Utility;

import java.util.ArrayList;

/**--------------------------------------------------------------------------------------
|	HexLocation Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Encapsulates the attributes of a Hexatile and takes care of the Mapping
|   to adjacent Tiles.
---------------------------------------------------------------------------------------*/

public class HexLocation implements ILocation{
    private int row, col;

    public HexLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public ArrayList<ILocation> getAdjacent(){

        ArrayList<ILocation> myAdj = new ArrayList<ILocation>();

        if(this.col % 2 == 0){
            //North
            myAdj.add(new HexLocation(this.row + -1, this.col + 0));

            //NorthWest
            myAdj.add(new HexLocation(this.row + -1, this.col + -1));

            //NorthEast
            myAdj.add(new HexLocation(this.row + -1, this.col + 1));

            //South
            myAdj.add(new HexLocation(this.row + 1, this.col + 0));

            //SouthWest
            myAdj.add(new HexLocation(this.row + 0, this.col + -1));

            //SouthEast
            myAdj.add(new HexLocation(this.row + 0, this.col + 1));
        }

        else{
            //North
            myAdj.add(new HexLocation(this.row + -1, this.col + 0));

            //NorthWest
            myAdj.add(new HexLocation(this.row + 0, this.col + -1));

            //NorthEast
            myAdj.add(new HexLocation(this.row + 0, this.col + 1));

            //South
            myAdj.add(new HexLocation(this.row + 1, this.col + 0));

            //SouthWest
            myAdj.add(new HexLocation(this.row + 1, this.col + -1));

            //SouthEast
            myAdj.add(new HexLocation(this.row + 1, this.col + 1));
        }

        return myAdj;
    }

    @Override
    public boolean equals(Object location){
        boolean equal = location instanceof HexLocation;
        if(!equal)
            return false;

        HexLocation myOther = (HexLocation)location;
        return this.equals(myOther);
    }


    public boolean equals(HexLocation hexLocation){
        return this.row == hexLocation.getRow() && this.col == hexLocation.getCol();
    }


    //TODO Maybe a directional system???
    public HexLocation getDirection(){return null;}
}
