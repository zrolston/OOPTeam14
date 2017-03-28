package Model.Utility;

import java.util.ArrayList;
import java.util.Objects;

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

        else{
            //North
            myAdj.add(new HexLocation(this.row + -1, this.col + 0));

            //NorthWest
            myAdj.add(new HexLocation(this.row + -1, this.col + -1));

            //NorthEast
            myAdj.add(new HexLocation(this.row + -1, this.col + 1));

            //South
            myAdj.add(new HexLocation(this.row + 1, this.col + 0));

            //SouthWest
            myAdj.add(new HexLocation(this.row, this.col + -1));

            //SouthEast
            myAdj.add(new HexLocation(this.row, this.col + 1));
        }

        return myAdj;
    }

    @Override
    public ILocation getLocationAtIndex(HexaIndex index) {

        ILocation myAdj = this;

        if(this.col % 2 == 0){

            switch(index.getValue()) {
                //North
                case 1: myAdj = (new HexLocation(this.row + -1, this.col + 0));
                break;

                //NorthEast
                case 2: myAdj = (new HexLocation(this.row, this.col + 1));
                break;

                //SouthEast
                case 3: myAdj = (new HexLocation(this.row + 1, this.col + 1));
                break;

                //South
                case 4: myAdj = (new HexLocation(this.row + 1, this.col + 0));
                break;

                //SouthWest
                case 5: myAdj = (new HexLocation(this.row + 1, this.col + -1));
                break;

                //NorthWest
                case 6: myAdj = (new HexLocation(this.row, this.col + -1));
                break;
            }
        }

        else{

            switch(index.getValue()) {
                //North
                case 1: myAdj = (new HexLocation(this.row + -1, this.col + 0));
                break;

                //NorthEast
                case 2: myAdj = (new HexLocation(this.row - 1, this.col + 1));
                break;

                //SouthEast
                case 3: myAdj = (new HexLocation(this.row, this.col + 1));
                break;

                //South
                case 4: myAdj = (new HexLocation(this.row + 1, this.col + 0));
                break;

                //SouthWest
                case 5: myAdj = (new HexLocation(this.row, this.col + -1));
                break;

                //NorthWest
                case 6: myAdj = (new HexLocation(this.row - 1, this.col + -1));
                break;

            }
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

    public String toString(){
        return "("+row+", "+col+")";
    }

    public int hashCode(){
        return Objects.hash(this.row, this.col);
    }

    public boolean equals(HexLocation hexLocation){
        return this.row == hexLocation.getRow() && this.col == hexLocation.getCol();
    }





}
