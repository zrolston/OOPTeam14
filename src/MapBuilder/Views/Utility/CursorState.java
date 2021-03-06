package MapBuilder.Views.Utility;


import java.awt.image.BufferedImage;

import MapBuilder.Model.Utility.HexLocation;

/**
 * Created by Ale on 3/27/2017.
 */
public class CursorState {

    //Available marker types
    public static final int NORMAL = 0, VALID = 1, INVALID = 2;

    private static CursorState ourInstance = new CursorState();
    private PixelPoint cursor;
    private PixelPoint dragged;
    private HexLocation activeTile;
    private boolean draggingTile = false;
    private boolean markerActive = true;
    private int markerType = NORMAL;
    private BufferedImage draggedImage = null;

    public static CursorState getInstance() {
        return ourInstance;
    }

    private CursorState() {
        cursor = new PixelPoint(0,0);
        dragged = new PixelPoint(0, 0);
        activeTile = new HexLocation(0,0);
    }


    public PixelPoint getCursor() { return cursor.clone(); }
    public PixelPoint getDragged() { return dragged.clone(); }
    public boolean isDraggingTile() { return draggingTile; }
    public BufferedImage getDraggedImage() { return draggedImage; }
    public boolean isMarkerActive(){ return markerActive; }
    public int getMarkerType() { return markerType; }


    public void setCursor(PixelPoint cursor) { this.cursor = cursor; }
    public void setCursor(int x, int y) {
        cursor.setY(x);
        cursor.setY(y);
    }

    public void setDragged(PixelPoint dragged) { this.dragged = dragged; }
    public void setDragged(int x, int y) {
        dragged.setX(x);
        dragged.setY(y);
    }

    public void startDraggingTile(){
        draggingTile = true;
    }
    public void stopDraggingTile(){
        draggingTile = false;
    }

    public HexLocation getActiveTile() {
        return activeTile;
    }

    public void setActiveTile(HexLocation activeTile) { this.activeTile = activeTile; }
    public void setDraggedImage(BufferedImage draggedImage) { this.draggedImage = draggedImage; }
    public void setMarkerActive(boolean markerActive) { this.markerActive = markerActive; }
    public void setMarkerType(int markerType) { this.markerType = markerType; }
}
