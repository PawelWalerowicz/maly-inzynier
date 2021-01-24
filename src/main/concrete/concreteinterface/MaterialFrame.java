package main.concrete.concreteinterface;

import main.concrete.Rebar;

import javax.swing.*;
import java.awt.*;

import static main.common.StandardGraphicParameters.*;

public class MaterialFrame {

    JFrame MainFrame;
    JPanel ConcreteWindow;
    JPanel MaterialPanel;


    //Constructor with colour, size and mainframe
    public MaterialFrame(JFrame MF, JPanel CW) {
        MainFrame = MF;
        ConcreteWindow = CW;
    }

    public JPanel MaterialFrameContent(JPanel CW) {
        ConcreteWindow = CW;


        //Material Panel
        MaterialPanel = new JPanel();
        MaterialPanel.setName("MaterialPanel");
        MaterialPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Materiały", 0, 0, plainFont));
        MaterialPanel.setPreferredSize(new Dimension(130, 230));
        MaterialPanel.setBackground(backgroundColor);
        SpringLayout MaterialPanelLayout = new SpringLayout();
        MaterialPanel.setLayout(MaterialPanelLayout);
        ConcreteWindow.add(MaterialPanel);

        //ConcreteClassLabel header
        JLabel ConcreteClassLabel = new JLabel("Klasa betonu:");
        MaterialPanel.add(ConcreteClassLabel);

        //Concrete class list
        JComboBox ConcreteClassList = new JComboBox(main.concrete.Concrete.classesStringList);
        ConcreteClassList.setBackground(Color.white);
        ConcreteClassList.setSelectedItem("C25/30");
        ConcreteClassList.setToolTipText("Wybierz klasę betonu");
        ConcreteClassList.setName("ConcreteClass");
        MaterialPanel.add(ConcreteClassList);

        //Main rebar steel class
        //MainRebarSteelLabel header
        JLabel MainRebarSteelLabel = new JLabel("Zbrojenie podłużne:");
        MaterialPanel.add(MainRebarSteelLabel);


        JLabel MainRebarClassLabel = new JLabel("Klasa:");
        MaterialPanel.add(MainRebarClassLabel);

        JComboBox MainRebarClassList = new JComboBox(Rebar.rebarClasses);
        MainRebarClassList.setBackground(Color.white);
        MainRebarClassList.setSelectedItem("A-IIIN");
        MainRebarClassList.setToolTipText("Wybierz klasę stali zbrojenia podłużnego");
        MainRebarClassList.setName("MainRebarClass");
        MaterialPanel.add(MainRebarClassList);

        JLabel UpperRebarDiameterLabel = new JLabel("\u03D5"+".g=");
        MaterialPanel.add(UpperRebarDiameterLabel);

        JComboBox UpperRebarDiameterList = new JComboBox(Rebar.rebarDiameters);
        UpperRebarDiameterList.setBackground(Color.white);
        UpperRebarDiameterList.setSelectedItem(16);
        UpperRebarDiameterList.setToolTipText("Wybierz średnicę zbrojenia górnego");
        UpperRebarDiameterList.setName("UpperRebarDiameter");
        MaterialPanel.add(UpperRebarDiameterList);




        JLabel DownRebarDiameterLabel = new JLabel("\u03D5"+".d=");
        DownRebarDiameterLabel.setFont(defaultFont);
        MaterialPanel.add(DownRebarDiameterLabel);

        JComboBox DownRebarDiameterList = new JComboBox(Rebar.rebarDiameters);
        DownRebarDiameterList.setBackground(Color.white);
        DownRebarDiameterList.setSelectedItem(16);
        DownRebarDiameterList.setToolTipText("Wybierz średnicę zbrojenia dolnego");
        DownRebarDiameterList.setName("DownRebarDiameter");
        MaterialPanel.add(DownRebarDiameterList);



        //Stirrups steel class
        //MainRebarSteelLabel header
        JLabel StirrupsRebarSteelLabel = new JLabel("Strzemiona:");
        MaterialPanel.add(StirrupsRebarSteelLabel);

        JComboBox StirrupsRebarClassList = new JComboBox(Rebar.rebarClasses);
        StirrupsRebarClassList.setBackground(Color.white);
        StirrupsRebarClassList.setSelectedItem("A-I");
        StirrupsRebarClassList.setToolTipText("Wybierz klasę stali strzemion");
        StirrupsRebarClassList.setName("StirrupsRebarClass");
        MaterialPanel.add(StirrupsRebarClassList);

        JComboBox StirrupsRebarDiameterList = new JComboBox(Rebar.rebarDiameters);
        StirrupsRebarDiameterList.setBackground(Color.white);
        StirrupsRebarDiameterList.setSelectedItem(8);
        StirrupsRebarDiameterList.setToolTipText("Wybierz średnicę strzemion");
        StirrupsRebarDiameterList.setName("StirrupsRebarDiameter");
        MaterialPanel.add(StirrupsRebarDiameterList);


        //Location of ConcreteClassLabel
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, ConcreteClassLabel,
                5,
                SpringLayout.WEST, MaterialPanel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, ConcreteClassLabel,
                0,
                SpringLayout.NORTH, MaterialPanel);

        //Location of ConcreteClassList
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, ConcreteClassList,
                5,
                SpringLayout.WEST, MaterialPanel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, ConcreteClassList,
                5,
                SpringLayout.SOUTH, ConcreteClassLabel);

        //Location of MainRebarSteelLabel
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, MainRebarSteelLabel,
                5,
                SpringLayout.WEST, MaterialPanel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, MainRebarSteelLabel,
                5,
                SpringLayout.SOUTH, ConcreteClassList);


        //Location of MainRebarClassLabel
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, MainRebarClassLabel,
                5,
                SpringLayout.WEST, MaterialPanel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, MainRebarClassLabel,
                10,
                SpringLayout.SOUTH, MainRebarSteelLabel);


        //Location of MainRebarClassList
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, MainRebarClassList,
                5,
                SpringLayout.EAST, MainRebarClassLabel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.SOUTH, MainRebarClassList,
                0,
                SpringLayout.SOUTH, MainRebarClassLabel);

        //Location of UpperRebarDiameterLabel
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, UpperRebarDiameterLabel,
                0,
                SpringLayout.WEST, MainRebarSteelLabel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, UpperRebarDiameterLabel,
                10,
                SpringLayout.SOUTH, MainRebarClassList);

        //Location of UpperRebarDiameterList
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, UpperRebarDiameterList,
                0,
                SpringLayout.WEST, MainRebarClassList);

        MaterialPanelLayout.putConstraint(
                SpringLayout.SOUTH, UpperRebarDiameterList,
                0,
                SpringLayout.SOUTH, UpperRebarDiameterLabel);

        //Location of DownRebarDiameterLabel
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, DownRebarDiameterLabel,
                0,
                SpringLayout.WEST, UpperRebarDiameterLabel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, DownRebarDiameterLabel,
                10,
                SpringLayout.SOUTH, UpperRebarDiameterLabel);


        //Location of DownRebarDiameterList
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, DownRebarDiameterList,
                0,
                SpringLayout.WEST, MainRebarClassList);

        MaterialPanelLayout.putConstraint(
                SpringLayout.SOUTH, DownRebarDiameterList,
                0,
                SpringLayout.SOUTH, DownRebarDiameterLabel);


        //Location of StirrupsRebarSteelLabel
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, StirrupsRebarSteelLabel,
                5,
                SpringLayout.WEST, MaterialPanel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, StirrupsRebarSteelLabel,
                10,
                SpringLayout.SOUTH, DownRebarDiameterLabel);

        //Location of MainRebarClassList
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, StirrupsRebarClassList,
                0,
                SpringLayout.WEST, StirrupsRebarSteelLabel);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, StirrupsRebarClassList,
                5,
                SpringLayout.SOUTH, StirrupsRebarSteelLabel);

        //Location of DownRebarDiameterList
        MaterialPanelLayout.putConstraint(
                SpringLayout.WEST, StirrupsRebarDiameterList,
                5,
                SpringLayout.EAST, StirrupsRebarClassList);

        MaterialPanelLayout.putConstraint(
                SpringLayout.NORTH, StirrupsRebarDiameterList,
                0,
                SpringLayout.NORTH, StirrupsRebarClassList);

        return MaterialPanel;
    }
}
