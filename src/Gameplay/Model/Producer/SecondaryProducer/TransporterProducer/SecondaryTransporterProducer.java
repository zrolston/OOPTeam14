package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer;

import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.Transporter;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class SecondaryTransporterProducer extends Producer {
    private TransporterFactory myFactory;

    public SecondaryTransporterProducer(TransporterFactory tf){
        myFactory = tf;
    }

    public abstract Transporter produce(UserRequest ur);

    protected Transporter generateOutputs() {
        return myFactory.create();
    }
}
