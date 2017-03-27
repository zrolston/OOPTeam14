package Model.Visitor;

import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileDrawingVisitor implements TileVisitor {
    private BufferedImage image;

    public TileDrawingVisitor(){
        try {
            image = ImageIO.read(new File("res/Images/mountain.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitSea(SeaTerrain sea) {
        try {
            image = ImageIO.read(new File("res/Images/sea.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitRock(RockTerrain rock) {
        try {
            image = ImageIO.read(new File("res/Images/rock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitDesert(DesertTerrain desert) {
        try {
            image = ImageIO.read(new File("res/Images/desert.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitPasture(PastureTerrain pasture) {
        try {
            image = ImageIO.read(new File("res/Images/pasture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitWoods(WoodsTerrain woods) {
        try {
            image = ImageIO.read(new File("res/Images/woods.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitMountain(MountainTerrain mountain) {
        try {
            image = ImageIO.read(new File("res/Images/mountain.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {

    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {

    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {

    }

    public BufferedImage getImage(){
        return image;
    }
}
