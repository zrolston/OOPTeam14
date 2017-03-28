package Model.Visitor;

import Model.Edge.*;
import Model.Terrain.*;
import Model.Utility.HexaIndex;
import Views.Utility.ImageLoader;
import javax.management.BadAttributeValueExpException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

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
    public void visitEdgeMap(EdgeMap edgeMap) {
        //Take care of the traversal
        Map<HexaIndex, Edge> edges = edgeMap.getEdges();
        edges.forEach(
                    (index, edge ) -> {
                        currentEdgeIndex = index.getValue() - 1;
                        edge.accept(this);
                    }
                );
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {
    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {
    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {
        riverIndices.add(currentEdgeIndex);
    }

    public BufferedImage getImage(){
        BufferedImage allTogether = terrainImage;
        Graphics g = allTogether.createGraphics();
        if(!riverIndices.isEmpty()){
            try {
                g.drawImage(getAdjustedRiverImage(), 0, 0, null);
            } catch (BadAttributeValueExpException e) {
                e.printStackTrace();
            }
        }

        BufferedImage outline = ImageLoader.getImage("OUTLINE");
        g.drawImage(outline, 0, 0, null);

        return allTogether;
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
