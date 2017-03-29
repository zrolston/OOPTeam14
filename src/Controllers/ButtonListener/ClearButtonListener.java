package Controllers.ButtonListener;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Views.MapEditor.MapEditorView;
import Views.MapEditor.ValidateAndMenuView;
import Views.MapEditor.MapView.MapSubsectionView;
import Model.Utility.FileIO;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ClearButtonListener implements ActionListener {
    private ModelFacade modelFacade = ModelFacade.getInstance();
    private MapSubsectionView mapSubsectionView;
    private MapEditorView mapEditorView;

    public ClearButtonListener(MapSubsectionView view, MapEditorView mapEditorView) {
        this.mapSubsectionView = view;
        this.mapEditorView = mapEditorView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modelFacade.clearMap();
        mapSubsectionView.updateCachedImages(BuildMap.getInstance());
        mapEditorView.updateImages();
    }
}
