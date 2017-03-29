package Controllers.ButtonListener;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Views.MapEditor.MapView.MapSubsectionView;
import Model.Utility.FileIO;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ClearButtonListener implements ActionListener {
    ModelFacade modelFacade=ModelFacade.getInstance();
    JButton button;

    public ClearButtonListener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modelFacade.clearMap();
        MapSubsectionView.updateCachedImages(BuildMap.getInstance());
    }
}
