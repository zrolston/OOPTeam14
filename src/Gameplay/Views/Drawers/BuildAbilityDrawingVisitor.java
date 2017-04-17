package Gameplay.Views.Drawers;

import Gameplay.Model.BuildAbilities.Neutral.*;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildOilRig;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildRowBoatFactory;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildSteamerFactory;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildTruckFactory;
import Gameplay.Model.Visitors.BuildAbilityVisitor;
import MapBuilder.Views.Utility.ImageLoader;

import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/17/2017.
 */
public class BuildAbilityDrawingVisitor implements BuildAbilityVisitor {

    BufferedImage image;

    @Override
    public void visitBuildClayPit(BuildClayPit bcp) {
        image = ImageLoader.getImage("CLAY_PIT");
    }

    @Override
    public void visitBuildCoalBurner(BuildCoalBurner bcb) {
        image = ImageLoader.getImage("COAL_BURNER");
    }

    @Override
    public void visitBuildMine(BuildMine bm) {
        image = ImageLoader.getImage("MINE");
    }

    @Override
    public void visitBuildMint(BuildMint bm) {
        image = ImageLoader.getImage("MINT");
    }

    @Override
    public void visitBuildPaperMill(BuildPaperMill bpm) {
        image = ImageLoader.getImage("PAPERMILL");
    }

    @Override
    public void visitBuildQuarry(BuildQuarry bq) {
        image = ImageLoader.getImage("STONE_QUARRY");
    }

    @Override
    public void visitBuildRaftFactory(BuildRaftFactory brf) {
        image = ImageLoader.getImage("RAFT_FACTORY");
    }

    @Override
    public void visitBuildSawMill(BuildSawMill bsm) {
        image = ImageLoader.getImage("SAWMILL");
    }

    @Override
    public void visitBuildStockMarket(BuildStockMarket bsm) {
        image = ImageLoader.getImage("STOCK_MARKET");
    }

    @Override
    public void visitBuildStoneFactory(BuildStoneFactory bsf) {
        image = ImageLoader.getImage("STONE_FACTORY");
    }

    @Override
    public void visitBuildWagonFactory(BuildWagonFactory bwf) {
        image = ImageLoader.getImage("WAGON_FACTORY");
    }

    @Override
    public void visitBuildWoodFactory(BuildWoodCutter bwc) {
        image = ImageLoader.getImage("WOODCUTTER");
    }

    @Override
    public void visitBuildOilRig(BuildOilRig bor) {
        image = ImageLoader.getImage("OIL_RIG");
    }

    @Override
    public void visitBuildRowBoatFactory(BuildRowBoatFactory brbf) {
        image = ImageLoader.getImage("ROWBOAT_FACTORY");
    }

    @Override
    public void visitBuildSteamerFactory(BuildSteamerFactory bsf) {
        image = ImageLoader.getImage("STEAMER_FACTORY");
    }

    @Override
    public void visitBuildTruckFactory(BuildTruckFactory btf) {
        image = ImageLoader.getImage("TRUCKER_FACTORY");
    }

    public BufferedImage getImage() {
        return image;
    }
}
