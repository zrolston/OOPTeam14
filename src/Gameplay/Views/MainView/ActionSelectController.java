package Gameplay.Views.MainView;

import Gameplay.Model.Utility.GameModelFacade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Thomas on 4/17/17.
 */
public class ActionSelectController {

    ActionSelectionView view;
    GameModelFacade model;

    public ActionSelectController(ActionSelectionView view) {
        this.view = view;
         model = model.getInstance();

         view.getB1().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

             }
         });
    }






}
