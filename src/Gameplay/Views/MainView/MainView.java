package Gameplay.Views.MainView;

import Gameplay.Views.Display;
import Gameplay.Views.ScreenSelectButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MainView extends JLayeredPane {
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

    int currPhase = 0;

    public MainView(Display display) {

        this.display = display;

         actionSelectionView = new ActionSelectionView();
         endPhaseButton = new EndPhaseButton();
         geeseFollowButton = new GeeseFollowButton();
         inputSelectionView = new InputSelectionView();
         mapView = new MapView();
         producerSelectionView = new ProducerSelectionView();
         regionCarriableView = new RegionCarriableView();
         researchSelectionView = new ResearchSelectionView();
         transporterCarriableView = new TransporterCarriableView();
         wallSelectionView = new WallSelectionView();
         screenSelectBtns = new ScreenSelectButtons();
         endPhaseButton = new EndPhaseButton();
         transporterCarriableView = new TransporterCarriableView();
         regionCarriableView = new RegionCarriableView();

        this.add(mapView, new Integer(1));
        this.add(endPhaseButton, new Integer(2));
        this.add(transporterCarriableView, new Integer(2));
        this.add(regionCarriableView, new Integer(2));
        this.add(screenSelectBtns, new Integer(2));

        addCustomListenersToScreenSelectBtns();
        addCustomListenersToNextPhaseBtn();
        setVisible(true);

        //Start Map Rendering Thread
        mapView.startRendering(30);
        System.out.println("here");
    }

    public void addCustomListenersToNextPhaseBtn() {
        endPhaseButton.addActionListenerToEndPhaseButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPhase = ++currPhase % 4;
                System.out.println(currPhase + " ");
            }
        } );
    }

    public void showTradingPhaseViews() {
        transporterCarriableView.setVisible(true);
        regionCarriableView.setVisible(true);
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
