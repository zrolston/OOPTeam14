package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer;

import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.Transporter;

/**
 * Created by Willie on 4/15/2017.
 */
public abstract class SecondaryTransporterProducer extends Producer {
    public abstract Transporter produce(UserRequest ur);
}
