package Gameplay.Views.MainView;

import Gameplay.Views.Display;
import Gameplay.Views.ScreenSelectButtons;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainView extends JPanel {
    ScreenSelectButtons screenSelectBtns;
    Display display;
    ActionSelectionView actionSelectionView;
    EndPhaseButton endPhaseButton;
    GeeseFollowButton geeseFollowButton;
    InputSelectionView inputSelectionView;
    MapView mapView;
    ProducerSelectionView producerSelectionView;
    RegionCarriableView regionCarriableView;
    ResearchSelectionView researchSelectionView;
    TransporterCarriableView transporterCarriableView;
    WallSelectionView wallSelectionView;

    public MainView(Display display) {
        setLayout(null);
         actionSelectionView = new ActionSelectionView();
         endPhaseButton = new EndPhaseButton();
         geeseFollowButton = new GeeseFollowButton();
         inputSelectionView = new InputSelectionView();
         mapView = new MapView();
         add(mapView);
         producerSelectionView = new ProducerSelectionView();
         regionCarriableView = new RegionCarriableView();
         researchSelectionView = new ResearchSelectionView();
         transporterCarriableView = new TransporterCarriableView();
         wallSelectionView = new WallSelectionView();


        this.display = display;
        screenSelectBtns = new ScreenSelectButtons();
        this.add(screenSelectBtns);
        addCustomListenersToScreenSelectBtns();
        setBackground( new Color( 0xff9de7d7 ) );
        setVisible(true);
    }

    public void addCustomListenersToScreenSelectBtns() {
        screenSelectBtns.addListnerToMainScreenButton( e -> display.setCurrScreen("MAIN_SCREEN") );
        screenSelectBtns.addListnerToWonderScreenButton( e -> display.setCurrScreen("WONDER_SCREEN") );
        screenSelectBtns.addListnerToResearchScreenButton( e -> display.setCurrScreen("RESEARCH_SCREEN") );
        screenSelectBtns.addListnerToTransporterScreenButton( e -> display.setCurrScreen("TRANSPORTER_SCREEN") );
    }


    public ScreenSelectButtons getScreenSelectBtns() {
        return screenSelectBtns;
    }

    public Display getDisplay() {
        return display;
    }

    public ActionSelectionView getActionSelectionView() {
        return actionSelectionView;
    }

    public EndPhaseButton getEndPhaseButton() {
        return endPhaseButton;
    }

    public GeeseFollowButton getGeeseFollowButton() {
        return geeseFollowButton;
    }

    public InputSelectionView getInputSelectionView() {
        return inputSelectionView;
    }

    public MapView getMapView() {
        return mapView;
    }

    public ProducerSelectionView getProducerSelectionView() {
        return producerSelectionView;
    }

    public RegionCarriableView getRegionCarriableView() {
        return regionCarriableView;
    }

    public ResearchSelectionView getResearchSelectionView() {
        return researchSelectionView;
    }

    public TransporterCarriableView getTransporterCarriableView() {
        return transporterCarriableView;
    }

    public WallSelectionView getWallSelectionView() {
        return wallSelectionView;
    }

}
