package Gameplay.Model.Builders;

import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Transporters.Transporter;

/**
 * Created by zrgam_000 on 4/15/2017.
 */
public abstract class Builder {

    ProducerRequest input;

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
