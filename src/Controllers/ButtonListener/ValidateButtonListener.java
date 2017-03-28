package Controllers.ButtonListener;

import Model.ModelFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Willie on 3/28/2017.
 */
public class ValidateButtonListener implements ActionListener {

    JButton button;

    public ValidateButtonListener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModelFacade model = ModelFacade.getInstance();
        if (model.validateMap())
            button.setBackground(Color.green);
        else
            button.setBackground(Color.red);
    }
}
