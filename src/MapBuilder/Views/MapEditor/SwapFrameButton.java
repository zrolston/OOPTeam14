package MapBuilder.Views.MapEditor;

import Gameplay.Views.Display;
import MapBuilder.Views.MapEditorDisplay;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

/**
 * Created by Thomas on 4/13/17.
 */
public class SwapFrameButton extends JButton {

    private Display displayFrame;
    private MapEditorDisplay frame;

    public SwapFrameButton(Display displayFrame, MapEditorDisplay frame) {
        this.setLayout( new BorderLayout() );
        this.displayFrame = displayFrame;
        this.frame = frame;
        setBounds((int)(PixelMap.SCREEN_WIDTH * 3/4), PixelMap.SCREEN_HEIGHT/40, PixelMap.SCREEN_WIDTH /10, (int)(PixelMap.SCREEN_HEIGHT * .075) );

        JLabel label = new JLabel( "MAIN MENU" );
        label.setFont(new Font("Serif", Font.BOLD, 15));
        this.add( label, BorderLayout.CENTER );


        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.setVisible( true );
                frame.setVisible( false );
                frame.dispose();
            }
        });

        setOpaque(false);
        setVisible( true );
    }

}
