package Gameplay.Model.Visitors;

import Gameplay.Model.Producer.PrimaryProducer.*;
import Gameplay.Model.Producer.SecondaryProducer.GoodProducer.*;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.LandTransporterProducers.TruckProducer;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.LandTransporterProducers.WagonProducer;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers.RaftProducer;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers.RowboatProducer;
import Gameplay.Model.Producer.SecondaryProducer.TransporterProducer.WaterTransporterProducers.SteamerProducer;

/**
 * Created by Willie on 4/15/2017.
 */
public interface ProducerVisitor {
    void visitWoodCutter(WoodCutter wc);
    void visitClayPit(ClayPit cp);
    void visitMine(Mine m);
    void visitStoneQuarry(StoneQuarry sq);
    void visitOilRig(OilRig or);
    void visitCoalBurner(CoalBurner cb);
    void visitSawmill(Sawmill s);
    void visitPapermill(Papermill p);
    void visitStoneFactory(StoneFactory sf);
    void visitMint(Mint m);
    void visitStockMarket(StockMarket sm);
    void visitWagonFactory(WagonProducer wf);
    void visitTruckFactory(TruckProducer tf);
    void visitRaftFactory(RaftProducer rf);;
    void visitRowboatFactory(RowboatProducer rf);
    void visitSteamerFactory(SteamerProducer sf);
}
