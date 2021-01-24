package main.concrete.concreteinterface;

import javax.swing.*;
import java.awt.*;

import static main.common.StandardGraphicParameters.*;

public class CrackFrame {
    JFrame MainFrame;
    JPanel ConcreteWindow;
    JPanel CrackPanel;

    public CrackFrame(JFrame MF, JPanel CW) {
        MainFrame = MF;
        ConcreteWindow = CW;
    }

    public JPanel CrackFrameContent(JPanel CW) {
        ConcreteWindow = CW;

        //Crack Panel
        CrackPanel = new JPanel();
        CrackPanel.setName("CrackPanel");
        CrackPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Zarysowanie", 0, 0, plainFont));
        CrackPanel.setPreferredSize(new Dimension(130, 65));
        CrackPanel.setBackground(backgroundColor);
        SpringLayout CrackPanelLayout = new SpringLayout();
        CrackPanel.setLayout(CrackPanelLayout);
        ConcreteWindow.add(CrackPanel);

        //Crack width

        JLabel wkLabel = new JLabel("w.g=");
        CrackPanel.add(wkLabel);
        JTextField wkInput = new JTextField("0.3", 3);
        wkInput.setToolTipText("Podaj dopuszczalną szerokość rysy");
        wkInput.setHorizontalAlignment(SwingConstants.RIGHT);
        wkInput.setFont(bigFont);
        wkInput.setName("wk");
        CrackPanel.add(wkInput);
        JLabel Unitmmwk = new JLabel("mm");
        CrackPanel.add(Unitmmwk);


        //Location of MEdg package
        CrackPanelLayout.putConstraint(
                SpringLayout.WEST, wkLabel,
                5,
                SpringLayout.WEST, CrackPanel);

        CrackPanelLayout.putConstraint(
                SpringLayout.NORTH, wkLabel,
                10,
                SpringLayout.NORTH, CrackPanel);

        CrackPanelLayout.putConstraint(
                SpringLayout.WEST, wkInput,
                1,
                SpringLayout.EAST, wkLabel);

        CrackPanelLayout.putConstraint(
                SpringLayout.SOUTH, wkInput,
                0,
                SpringLayout.SOUTH, wkLabel);

        CrackPanelLayout.putConstraint(
                SpringLayout.WEST, Unitmmwk,
                0,
                SpringLayout.EAST, wkInput);

        CrackPanelLayout.putConstraint(
                SpringLayout.SOUTH, Unitmmwk,
                0,
                SpringLayout.SOUTH, wkInput);

        return CrackPanel;
    }

}
