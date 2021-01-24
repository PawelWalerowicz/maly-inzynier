package main.concrete.concreteinterface;


import javax.swing.*;
import java.awt.*;

import static main.common.StandardGraphicParameters.*;

public class ReinforcementFrame {
    JFrame MainFrame;
    JPanel ConcreteWindow;
    JPanel ReinforcementPanel;

    //Constructor with colour, size and mainframe
    public ReinforcementFrame(JFrame MF, JPanel CW) {
        MainFrame = MF;
        ConcreteWindow = CW;
    }

    public JPanel ReinforcementFrameContent(JPanel CW) {
        ConcreteWindow = CW;
        //Material Panel
        ReinforcementPanel = new JPanel();
        ReinforcementPanel.setName("ReinforcementPanel");
        ReinforcementPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Zbrojenie", 0, 0, plainFont));
        ReinforcementPanel.setPreferredSize(new Dimension(270, 100));
        ReinforcementPanel.setBackground(backgroundColor);
        SpringLayout ReinforcementPanelLayout = new SpringLayout();
        ReinforcementPanel.setLayout(ReinforcementPanelLayout);
        ConcreteWindow.add(ReinforcementPanel);

        //Upper reinforcement
        JLabel As2Label = new JLabel("As2=");
        ReinforcementPanel.add(As2Label);

        JTextField As2Input = new JTextField("0", 4);
        As2Input.setToolTipText("Zbrojenie górne");
        As2Input.setHorizontalAlignment(SwingConstants.RIGHT);
        As2Input.setFont(bigFont);
        As2Input.setName("As2");
        ReinforcementPanel.add(As2Input);
        JLabel Unitcm2As2 = new JLabel("cm2");
        ReinforcementPanel.add(Unitcm2As2);

        JLabel As2InRebars = new JLabel("");
        As2InRebars.setName("As2InRebars");
        ReinforcementPanel.add(As2InRebars);


        //Location of As2 package
        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, As2Label,
                5,
                SpringLayout.WEST, ReinforcementPanel);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.NORTH, As2Label,
                5,
                SpringLayout.NORTH, ReinforcementPanel);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, As2Input,
                5,
                SpringLayout.EAST, As2Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, As2Input,
                0,
                SpringLayout.SOUTH, As2Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, Unitcm2As2,
                0,
                SpringLayout.EAST, As2Input);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, Unitcm2As2,
                0,
                SpringLayout.SOUTH, As2Input);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, As2InRebars,
                5,
                SpringLayout.EAST, Unitcm2As2);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, As2InRebars,
                0,
                SpringLayout.SOUTH, Unitcm2As2);



        //Lower reinforcement
        JLabel As1Label = new JLabel("As1=");
        ReinforcementPanel.add(As1Label);

        JTextField As1Input = new JTextField("0", 4);
        As1Input.setToolTipText("Zbrojenie dolne");
        As1Input.setHorizontalAlignment(SwingConstants.RIGHT);
        As1Input.setFont(bigFont);
        As1Input.setName("As1");
        ReinforcementPanel.add(As1Input);
        JLabel Unitcm2As1 = new JLabel("cm2");
        ReinforcementPanel.add(Unitcm2As1);

        JLabel As1InRebars = new JLabel("");
        As1InRebars.setName("As1InRebars");
        ReinforcementPanel.add(As1InRebars);

        //Location of As1 package
        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, As1Label,
                0,
                SpringLayout.WEST, As2Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.NORTH, As1Label,
                10,
                SpringLayout.SOUTH, As2Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, As1Input,
                0,
                SpringLayout.WEST, As2Input);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, As1Input,
                0,
                SpringLayout.SOUTH, As1Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, Unitcm2As1,
                0,
                SpringLayout.EAST, As1Input);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, Unitcm2As1,
                0,
                SpringLayout.SOUTH, As1Input);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, As1InRebars,
                5,
                SpringLayout.EAST, Unitcm2As1);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, As1InRebars,
                0,
                SpringLayout.SOUTH, Unitcm2As1);



        //Stirrup reinforcement
        JLabel AswLabel = new JLabel("Asw=");
        ReinforcementPanel.add(AswLabel);

        JTextField AswInput = new JTextField("0", 4);
        AswInput.setToolTipText("Strzemiona");
        AswInput.setHorizontalAlignment(SwingConstants.RIGHT);
        AswInput.setFont(bigFont);
        AswInput.setName("Asw");
        ReinforcementPanel.add(AswInput);
        JLabel Unitcm2Asw = new JLabel("cm2");
        ReinforcementPanel.add(Unitcm2Asw);

        //Location of Asw package
        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, AswLabel,
                0,
                SpringLayout.WEST, As1Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.NORTH, AswLabel,
                10,
                SpringLayout.SOUTH, As1Label);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, AswInput,
                0,
                SpringLayout.WEST, As2Input);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, AswInput,
                0,
                SpringLayout.SOUTH, AswLabel);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.WEST, Unitcm2Asw,
                0,
                SpringLayout.EAST, AswInput);

        ReinforcementPanelLayout.putConstraint(
                SpringLayout.SOUTH, Unitcm2Asw,
                0,
                SpringLayout.SOUTH, AswInput);







        return ReinforcementPanel;
    }
}
