package Gameplay.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScreenSelectButtons extends JPanel {

    private JButton mainScreenSelectButton;
    private JButton wonderScreenSelectButton;
    private JButton transporterScreenSelectButton;
    private JButton researchScreenSelectButton;

    public ScreenSelectButtons() {
        mainScreenSelectButton      = new JButton("MAIN VIEW");
        wonderScreenSelectButton = new JButton("WONDER VIEW");
        transporterScreenSelectButton = new JButton("TRANSPORTER VIEW");
        researchScreenSelectButton = new JButton("RESEARCH VIEW");

        mainScreenSelectButton.setFont(new Font("plain", Font.BOLD, 13));
        wonderScreenSelectButton.setFont(new Font("plain", Font.BOLD, 13));
        transporterScreenSelectButton.setFont(new Font("plain", Font.BOLD, 13));
        researchScreenSelectButton.setFont(new Font("plain", Font.BOLD, 13));

        this.add( mainScreenSelectButton );
        this.add(wonderScreenSelectButton);
        this.add(transporterScreenSelectButton);
        this.add(researchScreenSelectButton) ;

        this.setForeground( new Color(0xAAffccf8) );
        this.setOpaque(false);
    }

    public void addListnerToMainScreenButton(ActionListener a) {
        mainScreenSelectButton.addActionListener( a );
    }
    public void addListnerToWonderScreenButton(ActionListener a) {
        wonderScreenSelectButton.addActionListener( a );
    }
    public void addListnerToResearchScreenButton(ActionListener a) {
        researchScreenSelectButton.addActionListener( a );
    }
    public void addListnerToTransporterScreenButton(ActionListener a) {
        transporterScreenSelectButton.addActionListener( a );
    }

}