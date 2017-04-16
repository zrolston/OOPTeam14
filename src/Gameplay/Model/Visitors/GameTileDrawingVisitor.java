package Gameplay.Model.Visitors;

import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.HexaVertex;
import MapBuilder.Model.Terrain.*;
import MapBuilder.Views.Utility.ImageLoader;

import javax.management.BadAttributeValueExpException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameTileDrawingVisitor implements GameTileVisitor {
    private BufferedImage terrainImage;
    private ArrayList<Integer> riverIndices;

    public GameTileDrawingVisitor(){
        riverIndices = new ArrayList<>();
        terrainImage = null;
    }

    @Override
    public void visitRegionMap(RegionMap regionMap) {
        for (int i = 1; i <= 6; i++) {
            try {
                if(regionMap.hasRegionAt(HexaVertex.createVertex(i+6))){
                    riverIndices.add(i-1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    public BufferedImage getImage(){
        BufferedImage allTogether = terrainImage;

        BufferedImage copy = new BufferedImage(allTogether.getWidth(), allTogether.getHeight(), allTogether.getType());
        Graphics g = copy.createGraphics();
        g.drawImage(allTogether, 0, 0, null);

        if(!riverIndices.isEmpty()){
            try {
                g.drawImage(getAdjustedRiverImage(), 0, 0, null);
            } catch (BadAttributeValueExpException e) {
                e.printStackTrace();
            }
        }

        BufferedImage outline = ImageLoader.getImage("OUTLINE");
        g.drawImage(outline, 0, 0, null);
        g.dispose();

        return copy;
    }

    private BufferedImage getAdjustedRiverImage() throws BadAttributeValueExpException {
        int numSides = riverIndices.size();
        int startingIndex = riverIndices.get(0);
        BufferedImage temp;

        switch (numSides){
            case 1: {
                temp = ImageLoader.getImage("RIVER1");
                if(startingIndex != 0){
                    temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                }
                return temp;
            }
            case 2: {
                int difference = riverIndices.get(1) - startingIndex;
                if(difference == 1 || difference == 5){   //Adjacent
                    temp = ImageLoader.getImage("RIVER2-1");
                    if(difference == 5){
                        startingIndex = riverIndices.get(1);
                    }
                    if(startingIndex != 0){
                        temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                    }
                    return temp;
                }
                else if(difference == 2 || difference == 4){   //Intermediate
                    temp = ImageLoader.getImage("RIVER2-2");
                    if(difference == 4){
                        startingIndex = riverIndices.get(1);
                    }
                    if(startingIndex != 0){
                        temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                    }
                    return temp;
                }
                else{   //Opposite
                    temp = ImageLoader.getImage("RIVER2-3");
                    if(startingIndex != 0){
                        temp = rotateImage(temp, (startingIndex*Math.PI) / 3);
                    }
                    return temp;
                }
            }
            case 3:{
                temp = ImageLoader.getImage("RIVER3");
                if(startingIndex != 0){
                    temp = rotateImage(temp, (Math.PI) / 3);
                }
                return temp;
            }
            case 6:{
                return null;
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
