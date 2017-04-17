package Gameplay.Model.Producer.SecondaryProducer.TransporterProducer;

import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Map.TransporterHandler;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Producer.ProducerRequest;
import Gameplay.Model.Producer.SecondaryProducer.SecondaryProducer;
import Gameplay.Model.Producer.UserRequest;
import Gameplay.Model.Region.Region;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.Owned;

public abstract class SecondaryTransporterProducer extends SecondaryProducer {
    private TransporterFactory myFactory;
    private Region myRegion;
    private TransporterHandler transporterHandler;

    public SecondaryTransporterProducer(TransporterFactory tf, Region myRegion){
        myFactory = tf;
        this.myRegion = myRegion;
        transporterHandler = TransporterHandler.getInstance();
    }

    protected Transporter generateOutputs() {
        return myFactory.create();
    }

    public void produce(UserRequest ur){
        if(getCapacity() < 0){
            return;
        }
        for (ProducerRequest pr : getInputs()) {
            if(ur.contains(pr)){
                if(addTransporter(ur)) {
                    ur.removeUsed(pr);
                    ur.reset();
                    reduceCapacity();
                }
                return;
            }
        }
    }

    public abstract boolean addTransporter(Owned owned);

    public Region getRegion(){
        return myRegion;
    }

    protected TransporterHandler getTransporterHandler() {
        return transporterHandler;
    }
}
