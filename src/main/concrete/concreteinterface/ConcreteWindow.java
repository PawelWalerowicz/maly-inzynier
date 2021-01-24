package main.concrete.concreteinterface;

import main.concrete.Reinforcement;
import main.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static main.common.StandardGraphicParameters.*;

public class ConcreteWindow implements ActionListener {
    static int windowWidth = 925;
    static int windowHight = 450;

    //Elements requiring ActionListening
    JButton ReturnButton;
    JFrame MainFrame;
    JPanel MainWindow;
    JPanel ConcreteWindow;
    JPanel MaterialPanel;
    JPanel GeometryPanel;
    JPanel ForcesPanel;
    JCheckBox SLSCheckOption;
    JCheckBox MinReinfCheckOption;
    JPanel ReinforcementPanel;
    JPanel CrackPanel;
    JButton CalculateReinforcementButton;
    JButton CalculateForcesButton;
    ImageIcon RightButtonGraphic = new ImageIcon(this.getClass().getResource("/graphic/Right.png"));
    ImageIcon LeftButtonGraphic = new ImageIcon(this.getClass().getResource("/graphic/Left.png"));

    //Constructor with colour, size and mainframe
    public ConcreteWindow(JFrame MF, JPanel MW) {
        MainFrame = MF;
        MainWindow = MW;
    }

    public void ConcreteWindowContent() {
        //Resizing MainFrame
        MainFrame.setSize(windowWidth, windowHight);
        MainFrame.setLocation((resolutionWidth - windowWidth) / 2, (resolutionHeight - windowHight) / 2);
        //ConcreteWindow elements
        ConcreteWindow = new JPanel();
        SpringLayout ConcreteWindowLayout = new SpringLayout();
        ConcreteWindow.setLayout(ConcreteWindowLayout);
        ConcreteWindow.setBackground(backgroundColor);

        //Return To Main Menu Button
        ReturnButton = new JButton("Powrót");
        ReturnButton.setToolTipText("<html>"
                + "Powrót do menu wyboru narzędzi."
                + "<br>"
                + "Skrót klawiszowy: Alt+Q"
                + "</html>");
        ReturnButton.setMnemonic(KeyEvent.VK_Q);
        ReturnButton.addActionListener(this);
        ConcreteWindow.add(ReturnButton);

        //####################################################################

        //Location of ReturnButton
        ConcreteWindowLayout.putConstraint(
                SpringLayout.EAST, ReturnButton,
                -5,
                SpringLayout.EAST, ConcreteWindow);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.SOUTH, ReturnButton,
                -5,
                SpringLayout.SOUTH, ConcreteWindow);

        //####################################################################

        MaterialFrame Material = new MaterialFrame(MainFrame, ConcreteWindow);
        MaterialPanel = Material.MaterialFrameContent(ConcreteWindow);

        //Location of MaterialPanel
        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, MaterialPanel,
                5,
                SpringLayout.WEST, ConcreteWindow);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, MaterialPanel,
                5,
                SpringLayout.NORTH, ConcreteWindow);



        //####################################################################

        CrackFrame Crack = new CrackFrame(MainFrame, ConcreteWindow);
        CrackPanel = Crack.CrackFrameContent(ConcreteWindow);


        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, CrackPanel,
                0,
                SpringLayout.WEST, MaterialPanel);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, CrackPanel,
                5,
                SpringLayout.SOUTH, MaterialPanel);

        //####################################################################

        GeometryFrame Geometry = new GeometryFrame(MainFrame, ConcreteWindow);
        GeometryPanel = Geometry.GeometryFrameContent(ConcreteWindow);

        //Location of Geometry Panel
        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, GeometryPanel,
                5,
                SpringLayout.EAST, MaterialPanel);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, GeometryPanel,
                0,
                SpringLayout.NORTH, MaterialPanel);

        //####################################################################

        ForcesFrame Forces = new ForcesFrame(MainFrame, ConcreteWindow);
        ForcesPanel = Forces.ForcesFrameContent(ConcreteWindow);


        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, ForcesPanel,
                5,
                SpringLayout.EAST, GeometryPanel);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, ForcesPanel,
                0,
                SpringLayout.NORTH, GeometryPanel);

//####################################################################


        SLSCheckOption = new JCheckBox("Sprawdź stan graniczny użytkowalności");
        SLSCheckOption.setName("SLSCheckOption");
        SLSCheckOption.setToolTipText("<html>"
                + "Włącz/wyłącz sprawdzenie ugięć i zarysowań)"
                + "<br>"
                + "Skrót klawiszowy: Alt+Z"
                + "</html>");
        SLSCheckOption.setMnemonic(KeyEvent.VK_Z);
        SLSCheckOption.setSelected(true);
        SLSCheckOption.setBackground(backgroundColor);
        ConcreteWindow.add(SLSCheckOption);
        SLSCheckOption.addActionListener(this);


        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, SLSCheckOption,
                0,
                SpringLayout.WEST, ForcesPanel);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, SLSCheckOption,
                5,
                SpringLayout.SOUTH, ForcesPanel);

//####################################################################


        MinReinfCheckOption = new JCheckBox("Zbrojenie minimalne");
        MinReinfCheckOption.setName("MinReinfCheckOption");
        MinReinfCheckOption.setToolTipText("<html>"
                + "Włącz/wyłącz weyfikację zbrojenia minimalnego)"
                + "<br>"
                + "Skrót klawiszowy: Alt+X"
                + "</html>");
        MinReinfCheckOption.setMnemonic(KeyEvent.VK_X);
        MinReinfCheckOption.setSelected(true);
        MinReinfCheckOption.setBackground(backgroundColor);
        ConcreteWindow.add(MinReinfCheckOption);
        MinReinfCheckOption.addActionListener(this);


        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, MinReinfCheckOption,
                0,
                SpringLayout.WEST, SLSCheckOption);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, MinReinfCheckOption,
                5,
                SpringLayout.SOUTH, SLSCheckOption);


        //####################################################################



        //Calculate Reinforcement from forces Button
        CalculateReinforcementButton = new JButton("");
        CalculateReinforcementButton.setToolTipText("Oblicz zbrojenie na podstawie sił przekrojowych");
        CalculateReinforcementButton.setIcon(RightButtonGraphic);
        CalculateReinforcementButton.setPreferredSize(new Dimension(80, 40));
        CalculateReinforcementButton.addActionListener(this);
        ConcreteWindow.add(CalculateReinforcementButton);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, CalculateReinforcementButton,
                10,
                SpringLayout.EAST, ForcesPanel);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, CalculateReinforcementButton,
                8,
                SpringLayout.NORTH, ForcesPanel);


        //Calculate forces from reinforcement Button
        CalculateForcesButton = new JButton("");
        CalculateForcesButton.setToolTipText("Oblicz dopuszczalne siły przekrojowe na podstawie zbrojenia");
        CalculateForcesButton.setIcon(LeftButtonGraphic);
        CalculateForcesButton.setPreferredSize(new Dimension(80, 40));
        CalculateForcesButton.addActionListener(this);
        ConcreteWindow.add(CalculateForcesButton);


        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, CalculateForcesButton,
                10,
                SpringLayout.EAST, ForcesPanel);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.SOUTH, CalculateForcesButton,
                -3,
                SpringLayout.SOUTH, ForcesPanel);




        //####################################################################


        ReinforcementFrame Reinf = new ReinforcementFrame(MainFrame, ConcreteWindow);
        ReinforcementPanel = Reinf.ReinforcementFrameContent(ConcreteWindow);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.WEST, ReinforcementPanel,
                10,
                SpringLayout.EAST, CalculateReinforcementButton);

        ConcreteWindowLayout.putConstraint(
                SpringLayout.NORTH, ReinforcementPanel,
                0,
                SpringLayout.NORTH, ForcesPanel);

        //Adding elements to the source frame
        MainFrame.add(ConcreteWindow);
        ConcreteWindow.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        Object Source = ae.getSource();
        if (Source == ReturnButton) {
            ConcreteWindow.setVisible(false);
            MainFrame.remove(ConcreteWindow);
            MainFrame.add(MainWindow);
            MainWindow MAIN = new MainWindow(MainFrame);
            MAIN.MainWindowContent();
        }

        if (Source == SLSCheckOption) {
            Component[] ForcesList = ForcesPanel.getComponents();
            for (int i = 0; i < ForcesList.length; i++) {
                if (ForcesList[i] instanceof JTextField) {
                    String InputWindow = ForcesList[i].getName();
                    if ((InputWindow.equals("MEk")) | (InputWindow.equals("VEk"))) {
                        ForcesList[i].setEnabled(!ForcesList[i].isEnabled());

                    }
                }
            }
            Component[] CrackList = CrackPanel.getComponents();
            for (int i = 0; i < CrackList.length; i++) {
                if (ForcesList[i] instanceof JTextField) {
                    String InputWindow = CrackList[i].getName();
                    if (InputWindow.equals("wk")) {
                        CrackList[i].setEnabled(!CrackList[i].isEnabled());

                    }
                }
            }
        }


//wprowadź gdzieś, żeby sprawdzało z minimalnym
        if (Source == CalculateReinforcementButton) {
            System.out.println("Klykło ( ͡° ͜ʖ ͡°) ");
            Reinforcement.manageReinforcement(ConcreteWindow);
        }

    }
}

