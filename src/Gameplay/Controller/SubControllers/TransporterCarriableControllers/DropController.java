package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Model.Region.Region;

/**
 * Created by jordi on 4/17/2017.
 */
public interface DropController {
    void dropCarriable(Region region);
    void changeToDefaultController();
    void sendCarriable();
    void sendTransporter();
}
