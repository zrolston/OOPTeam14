package MapBuilder.Controllers.ButtonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Views.MapEditor.MapEditorView;
import MapBuilder.Views.MapEditor.MapView.MapSubsectionView;


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
