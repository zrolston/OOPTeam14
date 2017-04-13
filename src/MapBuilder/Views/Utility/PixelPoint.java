package MapBuilder.Views.Utility;
/**-------------------------------------------------------------------------------------
|	PixelPoint Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Encapsulates Pixel Coordinates to be Integers (unlike Native Point class).
---------------------------------------------------------------------------------------*/

public class PixelPoint {
    private int x, y;

    public PixelPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PixelPoint() {
        x = 0;
        y = 0;
    }

    //Getters
    public int getX() { return x; }
    public int getY() { return y; }

    //Setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void moveX(int offset){ this.x += offset; }
    public void moveY(int offset){ this.y += offset; }

    public PixelPoint clone(){
        return new PixelPoint(getX(), getY());
    }
    public boolean equals(PixelPoint point){
        return (x == point.getX() && y == point.getY());
    }

    public String toString(){
        return "("+x+", "+y+")";
    }
}
