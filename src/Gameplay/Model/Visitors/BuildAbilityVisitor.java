package Gameplay.Model.Visitors;

import Gameplay.Model.BuildAbilities.Neutral.*;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildOilRig;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildRowBoatFactory;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildSteamerFactory;
import Gameplay.Model.BuildAbilities.PlayerSpecific.BuildTruckFactory;

/**
 * Created by Willie on 4/17/2017.
 */
public interface BuildAbilityVisitor {
    void visitBuildClayPit(BuildClayPit bcp);
    void visitBuildCoalBurner(BuildCoalBurner bcb);
    void visitBuildMine(BuildMine bm);
    void visitBuildMint(BuildMint bm);
    void visitBuildPaperMill(BuildPaperMill bpm);
    void visitBuildQuarry(BuildQuarry bq);
    void visitBuildRaftFactory(BuildRaftFactory brf);
    void visitBuildSawMill(BuildSawMill bsm);
    void visitBuildStockMarket(BuildStockMarket bsm);
    void visitBuildStoneFactory(BuildStoneFactory bsf);
    void visitBuildWagonFactory(BuildWagonFactory bwf);
    void visitBuildWoodFactory(BuildWoodCutter bwc);
    void visitBuildOilRig(BuildOilRig bor);
    void visitBuildRowBoatFactory(BuildRowBoatFactory brbf);
    void visitBuildSteamerFactory(BuildSteamerFactory bsf);
    void visitBuildTruckFactory(BuildTruckFactory btf);
}
