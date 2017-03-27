package Model.Visitor;

import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.*;
import Views.ViewUtility.ImageLoader;

import javax.management.BadAttributeValueExpException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileDrawingVisitor implements TileVisitor {
    private BufferedImage terrainImage;
    private int currentEdgeIndex;
    private ArrayList<Integer> riverIndices;

    public TileDrawingVisitor(){
        riverIndices = new ArrayList<>();
        currentEdgeIndex = 0;
        terrainImage = null;
    }

    @Override
    public void visitSea(SeaTerrain sea) {
        terrainImage = ImageLoader.getImage("SEA");
    }

    @Override
    public void visitRock(RockTerrain rock) {
        terrainImage = ImageLoader.getImage("ROCK");
    }

    @Override
    public void visitDesert(DesertTerrain desert) {
        terrainImage = ImageLoader.getImage("DESERT");
    }

    @Override
    public void visitPasture(PastureTerrain pasture) {
        terrainImage = ImageLoader.getImage("PASTURE");
    }

    @Override
    public void visitWoods(WoodsTerrain woods) {
        terrainImage = ImageLoader.getImage("WOODS");
    }

    @Override
    public void visitMountain(MountainTerrain mountain) {
        terrainImage = ImageLoader.getImage("MOUNTAIN");
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {
        currentEdgeIndex++;
        //TODO Decouple this from assuming edgeList in tile is ordered
    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {
        currentEdgeIndex++;
    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {
        riverIndices.add(currentEdgeIndex);
        currentEdgeIndex++;
    }

    public BufferedImage getImage(){
        BufferedImage allTogether = terrainImage;
        if(!riverIndices.isEmpty()){
            Graphics g = allTogether.getGraphics();
            try {
                g.drawImage(getAdjustedRiverImage(), 0, 0, null);
            } catch (BadAttributeValueExpException e) {
                e.printStackTrace();
            }
        }
        return allTogether;
    }

    private BufferedImage getAdjustedRiverImage() throws BadAttributeValueExpException {
        int numSides = riverIndices.size();
        int startingIndex = riverIndices.get(0);
        BufferedImage temp;

        switch (numSides){
            case 1: {
                temp = ImageLoader.getImage("RIVER0");
                if(startingIndex != 0){
                    temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                }
                return temp;
            }
            case 2: {
                int difference = riverIndices.get(1) - startingIndex;
                if(difference == 1 || difference == 5){   //Adjacent
                    temp = ImageLoader.getImage("RIVER1");
                    if(riverIndices.get(1) == 5){
                        startingIndex = 5;
                    }
                    if(startingIndex != 0){
                        temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                    }
                    return temp;
                }
                else if(difference == 2 || difference == 4){   //Intermediate
                    temp = ImageLoader.getImage("RIVER2");
                    if(riverIndices.get(1) == 5){
                        startingIndex = 5;
                    }
                    if(startingIndex != 0){
                        temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                    }
                    return temp;
                }
                else{   //Opposite
                    temp = ImageLoader.getImage("RIVER3");
                    if(startingIndex != 0){
                        temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                    }
                    return temp;
                }
            }
            case 3:{
                temp = ImageLoader.getImage("RIVER2-2");
                if(startingIndex != 0){
                    temp = rotateImage(temp, (Math.PI) / 3);
                }
                return temp;
            }
            default: throw new BadAttributeValueExpException("");
        }
    }

    private BufferedImage rotateImage(BufferedImage old, double radians){
        AffineTransform tx = new AffineTransform();
        tx.rotate(radians, old.getWidth() / 2, old.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(old, null);
    }
}
