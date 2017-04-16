package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer;

import Gameplay.Model.Goods.Board;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.TransporterFactory.RowboatFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Transporters.WaterTransporter.Rowboat;
import Gameplay.Model.Visitors.ProducerVisitor;

/**
 * Created by Willie on 4/15/2017.
 */
public class RowboatProducer extends SecondaryTransporterProducer {

    private ProducerRequest input;

    public RowboatProducer() {
        super(new RowboatFactory());
        generateInput();
    }

    private void generateInput() {
        GoodsBag goods = new GoodsBag();
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        goods.addBoard(new Board());
        input = new ProducerRequest(goods, null);
    }

    @Override
    public void accept(ProducerVisitor pv) {
        pv.visitRowboatFactory(this);
    }

    @Override
    public Transporter produce(UserRequest ur) {
        if (!ur.contains(input))
            return null;
        else {
            ur.removeUsed(input);
            ur.reset();
            return generateOutputs();
        }
    }
}
