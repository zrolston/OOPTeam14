package Gameplay.Views.MainView;

import Gameplay.Views.Display;
import Gameplay.Views.ScreenSelectButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    ArrayList<JComponent> subViews = new ArrayList<>();

    int currPhase = 0;

    public MainView(Display display) {

        this.display = display;

         actionSelectionView = new ActionSelectionView();
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

        subViews.add( actionSelectionView );
        subViews.add( geeseFollowButton );
        subViews.add( inputSelectionView );
        subViews.add( producerSelectionView );
        subViews.add( regionCarriableView );
        subViews.add( researchSelectionView );
        subViews.add( transporterCarriableView );
        subViews.add( wallSelectionView );
        hideAllPhaseSubViews();

        this.add(mapView, new Integer(1));
        this.add(endPhaseButton, new Integer(2));
        this.add(transporterCarriableView, new Integer(2));
        this.add(regionCarriableView, new Integer(2));
        this.add(actionSelectionView, new Integer(2));
        this.add(producerSelectionView, new Integer(2));
        this.add(wallSelectionView, new Integer(2));
        this.add(inputSelectionView, new Integer(2));
        this.add(geeseFollowButton, new Integer(3));
        this.add(screenSelectBtns, new Integer(2));


        addCustomListenersToScreenSelectBtns();
        addCustomListenersToNextPhaseBtn();
        setVisible(true);

        //Start Map Rendering Thread
        mapView.startRendering(30);
    }

    public void addCustomListenersToNextPhaseBtn() {
        endPhaseButton.addActionListenerToEndPhaseButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currPhase = ++currPhase % 5;

                hideAllPhaseSubViews();

                switch (currPhase) {        // DO NOT BE ALARMED!!! FOR TESTING PURPOSES ONLY!
                    case 0:                                         // aka until Jordi fixes his controllers
                        showTradingPhaseViews();
                        break;
                    case 1:
                        showProductionPhaseViews();
                        break;
                    case 2:
                        showMovementPhaseViews();
                        break;
                    case 3:
                        showBuildingPhaseViews();
                        break;
                    case 4:
                        showWonderPhaseViews();
                        break;
                }

            }
        } );
    }

    public void hideAllPhaseSubViews() {
        for(JComponent v : subViews)
            v.setVisible( false );
    }
    public void showTradingPhaseViews() {
        transporterCarriableView.setVisible( true );
        regionCarriableView.setVisible( true );
        endPhaseButton.setPhaseLabel( "  TRADING" );
    }
    public void showProductionPhaseViews() {
        transporterCarriableView.setVisible( true );
        regionCarriableView.setVisible( true );
        producerSelectionView.setVisible( true );
        inputSelectionView.setVisible( true );
        actionSelectionView.setVisible( true );
        endPhaseButton.setPhaseLabel( "  PRODUCTION" );
    }
    public void showMovementPhaseViews() {
        transporterCarriableView.setVisible( true );
        regionCarriableView.setVisible( true );
        geeseFollowButton.setVisible( true );
        actionSelectionView.setVisible( true );
        endPhaseButton.setPhaseLabel( "  MOVEMENT" );
    }
    public void showBuildingPhaseViews() {
        transporterCarriableView.setVisible( true );
        regionCarriableView.setVisible( true );
        producerSelectionView.setVisible( true );
        inputSelectionView.setVisible( true );
        wallSelectionView.setVisible( true );
        actionSelectionView.setVisible( true );
        endPhaseButton.setPhaseLabel( "  BUILDING" );
    }
    public void showWonderPhaseViews() {
        transporterCarriableView.setVisible( true );
        regionCarriableView.setVisible( true );
        inputSelectionView.setVisible( true );
        endPhaseButton.setPhaseLabel( "  WONDER" );
    }

    public void addCustomListenersToScreenSelectBtns() {
        screenSelectBtns.addListnerToMainScreenButton( e -> display.displayMainScreen() );
        screenSelectBtns.addListnerToWonderScreenButton( e -> display.displayWonderScreen() );
        screenSelectBtns.addListnerToResearchScreenButton( e -> display.displayResearchScreen() );
        screenSelectBtns.addListnerToTransporterScreenButton( e -> display.displayTransporterScreen() );
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
