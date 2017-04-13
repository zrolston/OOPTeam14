package MapBuilder.Model.Utility.MapParsers;

/**
 * Created by jordi on 3/27/2017.
 */
public class CubeLocation {
    private int x;
    private int y;
    private int z;

    public CubeLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void addEquals(CubeLocation foreign){
        x+=foreign.getX();
        y+=foreign.getY();
        z+=foreign.getZ();
    }

    public void substractEquals(CubeLocation foreign){
        x-=foreign.getX();
        y-=foreign.getY();
        z-=foreign.getZ();
    }



    @Override
    public String toString() {
        return "("+x+", "+y+", "+z+")";
    }
}
