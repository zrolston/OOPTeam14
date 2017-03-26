package Model.Utility;
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
}
