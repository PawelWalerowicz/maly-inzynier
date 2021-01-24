package main.concrete.concreteinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static main.common.StandardGraphicParameters.*;

public class GeometryFrame implements ActionListener {

    JFrame MainFrame;
    JPanel ConcreteWindow;

    //Elements requiring ActionListening
    JButton BeamShapeButton;
    JPanel GeometryPanel;
    ImageIcon RectBeamGraphic = new ImageIcon(this.getClass().getResource("/graphic/RectBeam.png"));
    ImageIcon TBeamGraphic = new ImageIcon(this.getClass().getResource("/graphic/TBeam.png"));
    String beamType;

    JLabel beamhfLabel;
    JTextField beamhfInput;
    JLabel UnitCMHF;

    JLabel beambeff1Label;
    JTextField beambeff1Input;
    JLabel UnitCMBEFF1;

    JLabel beambeff2Label;
    JTextField beambeff2Input;
    JLabel UnitCMBEFF2;

    JCheckBox IsBeamRectangularInvisibleCheck;

    public GeometryFrame(JFrame MF, JPanel CW) {
        MainFrame = MF;
        ConcreteWindow = CW;
    }

    public JPanel GeometryFrameContent(JPanel CW) {
        ConcreteWindow = CW;


        //Geometry Panel
        GeometryPanel = new JPanel();
        GeometryPanel.setName("GeometryPanel");
        GeometryPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Geometria", 0, 0, plainFont));
        GeometryPanel.setPreferredSize(new Dimension(130, 300));
        GeometryPanel.setBackground(backgroundColor);
        SpringLayout GeometryPanelLayout = new SpringLayout();
        GeometryPanel.setLayout(GeometryPanelLayout);
        ConcreteWindow.add(GeometryPanel);

        //UpperCoverInput
        JLabel UpperCoverLabel = new JLabel("Otulina górna:");
        GeometryPanel.add(UpperCoverLabel);
        JTextField UpperCoverInput = new JTextField("20", 2);
        UpperCoverInput.setToolTipText("<html>"
                + "Podaj otulinę zbrojenia"
                + "<br>"
                + "(od lica betonu do lica pręta zbrojeniowego)"
                + "</html>");
        UpperCoverInput.setHorizontalAlignment(SwingConstants.CENTER);
        UpperCoverInput.setFont(bigFont);
        UpperCoverInput.setName("UpperCover");
        GeometryPanel.add(UpperCoverInput);
        JLabel UnitMMUC = new JLabel("mm");
        GeometryPanel.add(UnitMMUC);

        //LowerCoverInput
        JLabel LowerCoverLabel = new JLabel("Otulina dolna:");
        GeometryPanel.add(LowerCoverLabel);
        JTextField LowerCoverInput = new JTextField("20", 2);
        LowerCoverInput.setToolTipText("<html>"
                + "Podaj otulinę zbrojenia"
                + "<br>"
                + "(od lica betonu do lica pręta zbrojeniowego)"
                + "</html>");
        LowerCoverInput.setHorizontalAlignment(SwingConstants.CENTER);
        LowerCoverInput.setFont(bigFont);
        LowerCoverInput.setName("DownCover");
        GeometryPanel.add(LowerCoverInput);
        JLabel UnitMMLC = new JLabel("mm");
        GeometryPanel.add(UnitMMLC);

        //BeamShape Button
        JLabel BeamShapeButtonLabel = new JLabel("Kształt belki:");
        GeometryPanel.add(BeamShapeButtonLabel);
        BeamShapeButton = new JButton("");
        BeamShapeButton.setIcon(RectBeamGraphic);
        BeamShapeButton.setToolTipText("<html>"
                + "Wybierz kształ belki (prostokątna lub teowa)"
                + "<br>"
                + "Skrót klawiszowy: Alt+T"
                + "</html>");
        BeamShapeButton.setMnemonic(KeyEvent.VK_T);
        BeamShapeButton.addActionListener(this);
        BeamShapeButton.setPreferredSize(new Dimension(100, 100));
        GeometryPanel.add(BeamShapeButton);

        IsBeamRectangularInvisibleCheck = new JCheckBox();
        IsBeamRectangularInvisibleCheck.setSelected(true);
        IsBeamRectangularInvisibleCheck.setName("IsBeamRectangularInvisibleCheck");
        IsBeamRectangularInvisibleCheck.setVisible(false);
        GeometryPanel.add(IsBeamRectangularInvisibleCheck);

        //Beam shape
        JLabel beambLabel = new JLabel("b=");
        GeometryPanel.add(beambLabel);
        JTextField beambInput = new JTextField("25", 3);
        beambInput.setToolTipText("Podaj szerokość belki");
        beambInput.setHorizontalAlignment(SwingConstants.RIGHT);
        beambInput.setFont(bigFont);
        beambInput.setName("beamb");
        GeometryPanel.add(beambInput);
        JLabel UnitCMBB = new JLabel("cm");
        GeometryPanel.add(UnitCMBB);

        JLabel beamhLabel = new JLabel("h=");
        GeometryPanel.add(beamhLabel);
        JTextField beamhInput = new JTextField("50", 3);
        beamhInput.setToolTipText("Podaj wysokość belki");
        beamhInput.setHorizontalAlignment(SwingConstants.RIGHT);
        beamhInput.setFont(bigFont);
        beamhInput.setName("beamh");
        GeometryPanel.add(beamhInput);
        JLabel UnitCMBH = new JLabel("cm");
        GeometryPanel.add(UnitCMBH);

        beamhfLabel = new JLabel("hf=");
        GeometryPanel.add(beamhfLabel);
        beamhfInput = new JTextField("", 3);
        beamhfInput.setToolTipText("Podaj grubość płyty");
        beamhfInput.setHorizontalAlignment(SwingConstants.RIGHT);
        beamhfInput.setFont(bigFont);
        beamhfInput.setName("beamhf");
        GeometryPanel.add(beamhfInput);
        UnitCMHF = new JLabel("cm");
        GeometryPanel.add(UnitCMHF);
        beamhfLabel.setVisible(false);
        beamhfInput.setEnabled(false);
        beamhfInput.setVisible(false);
        UnitCMHF.setVisible(false);

        beambeff1Label = new JLabel("beff1=");
        GeometryPanel.add(beambeff1Label);
        beambeff1Input = new JTextField("", 3);
        beambeff1Input.setToolTipText("Podaj szerokość lewej półki");
        beambeff1Input.setHorizontalAlignment(SwingConstants.RIGHT);
        beambeff1Input.setFont(bigFont);
        beambeff1Input.setName("beambeff1");
        GeometryPanel.add(beambeff1Input);
        UnitCMBEFF1 = new JLabel("cm");
        GeometryPanel.add(UnitCMBEFF1);
        beambeff1Label.setVisible(false);
        beambeff1Input.setEnabled(false);
        beambeff1Input.setVisible(false);
        UnitCMBEFF1.setVisible(false);

        beambeff2Label = new JLabel("beff2=");
        GeometryPanel.add(beambeff2Label);
        beambeff2Input = new JTextField("", 3);
        beambeff2Input.setToolTipText("Podaj szerokość prawej półki");
        beambeff2Input.setHorizontalAlignment(SwingConstants.RIGHT);
        beambeff2Input.setFont(bigFont);
        beambeff2Input.setName("beambeff2");
        GeometryPanel.add(beambeff2Input);
        UnitCMBEFF2 = new JLabel("cm");
        GeometryPanel.add(UnitCMBEFF2);
        beambeff2Label.setVisible(false);
        beambeff2Input.setEnabled(false);
        beambeff2Input.setVisible(false);
        UnitCMBEFF2.setVisible(false);


        //Location of UpperCoverInput package
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UpperCoverLabel,
                5,
                SpringLayout.WEST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, UpperCoverLabel,
                0,
                SpringLayout.NORTH, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UpperCoverInput,
                1,
                SpringLayout.WEST, UpperCoverLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, UpperCoverInput,
                5,
                SpringLayout.SOUTH, UpperCoverLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitMMUC,
                0,
                SpringLayout.EAST, UpperCoverInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitMMUC,
                0,
                SpringLayout.SOUTH, UpperCoverInput);


        //Location of LowerCoverInput package
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, LowerCoverLabel,
                0,
                SpringLayout.WEST, UpperCoverLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, LowerCoverLabel,
                5,
                SpringLayout.SOUTH, UpperCoverInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, LowerCoverInput,
                1,
                SpringLayout.WEST, LowerCoverLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, LowerCoverInput,
                5,
                SpringLayout.SOUTH, LowerCoverLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitMMLC,
                0,
                SpringLayout.EAST, LowerCoverInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitMMLC,
                0,
                SpringLayout.SOUTH, LowerCoverInput);

        //Location of ShapedBeam

        GeometryPanelLayout.putConstraint(
                SpringLayout.HORIZONTAL_CENTER, BeamShapeButtonLabel,
                0,
                SpringLayout.HORIZONTAL_CENTER, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, BeamShapeButtonLabel,
                5,
                SpringLayout.SOUTH, LowerCoverInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.HORIZONTAL_CENTER, BeamShapeButton,
                0,
                SpringLayout.HORIZONTAL_CENTER, BeamShapeButtonLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, BeamShapeButton,
                5,
                SpringLayout.SOUTH, BeamShapeButtonLabel);


        //Location of Beam geometry package
        //b:
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beambLabel,
                5,
                SpringLayout.WEST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, beambLabel,
                10,
                SpringLayout.SOUTH, BeamShapeButton);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beambInput,
                -70,
                SpringLayout.EAST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, beambInput,
                0,
                SpringLayout.SOUTH, beambLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitCMBB,
                0,
                SpringLayout.EAST, beambInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitCMBB,
                0,
                SpringLayout.SOUTH, beambInput);


        //h:
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beamhLabel,
                0,
                SpringLayout.WEST, beambLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, beamhLabel,
                10,
                SpringLayout.SOUTH, beambLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beamhInput,
                -70,
                SpringLayout.EAST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, beamhInput,
                0,
                SpringLayout.SOUTH, beamhLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitCMBH,
                0,
                SpringLayout.EAST, beamhInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitCMBH,
                0,
                SpringLayout.SOUTH, beamhInput);

        //hf:
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beamhfLabel,
                0,
                SpringLayout.WEST, beamhLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, beamhfLabel,
                10,
                SpringLayout.SOUTH, beamhLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beamhfInput,
                -70,
                SpringLayout.EAST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, beamhfInput,
                0,
                SpringLayout.SOUTH, beamhfLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitCMHF,
                0,
                SpringLayout.EAST, beamhfInput);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitCMHF,
                0,
                SpringLayout.SOUTH, beamhfInput);

        //beff1:
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beambeff1Label,
                0,
                SpringLayout.WEST, beamhfLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, beambeff1Label,
                10,
                SpringLayout.SOUTH, beamhfLabel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beambeff1Input,
                -70,
                SpringLayout.EAST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, beambeff1Input,
                0,
                SpringLayout.SOUTH, beambeff1Label);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitCMBEFF1,
                0,
                SpringLayout.EAST, beambeff1Input);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitCMBEFF1,
                0,
                SpringLayout.SOUTH, beambeff1Input);

        //beff2:
        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beambeff2Label,
                0,
                SpringLayout.WEST, beambeff1Label);

        GeometryPanelLayout.putConstraint(
                SpringLayout.NORTH, beambeff2Label,
                10,
                SpringLayout.SOUTH, beambeff1Label);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, beambeff2Input,
                -70,
                SpringLayout.EAST, GeometryPanel);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, beambeff2Input,
                0,
                SpringLayout.SOUTH, beambeff2Label);

        GeometryPanelLayout.putConstraint(
                SpringLayout.WEST, UnitCMBEFF2,
                0,
                SpringLayout.EAST, beambeff2Input);

        GeometryPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitCMBEFF2,
                0,
                SpringLayout.SOUTH, beambeff2Input);

        return GeometryPanel;

    }

    public void actionPerformed(ActionEvent ae) {
        Object SourceButton = ae.getSource();

        if (SourceButton == BeamShapeButton) {
            if (BeamShapeButton.getIcon() == RectBeamGraphic) {
                BeamShapeButton.setIcon(TBeamGraphic);
                IsBeamRectangularInvisibleCheck.setSelected(false);
                GeometryPanel.setPreferredSize(new Dimension(130, 375));
                beamhfLabel.setVisible(true);
                beamhfInput.setEnabled(true);
                beamhfInput.setText("20");
                beamhfInput.setVisible(true);
                UnitCMHF.setVisible(true);
                beambeff1Label.setVisible(true);
                beambeff1Input.setEnabled(true);
                beambeff1Input.setText("50");
                beambeff1Input.setVisible(true);
                UnitCMBEFF1.setVisible(true);
                beambeff2Label.setVisible(true);
                beambeff2Input.setEnabled(true);
                beambeff2Input.setText("50");
                beambeff2Input.setVisible(true);
                UnitCMBEFF2.setVisible(true);
            } else {
                BeamShapeButton.setIcon(RectBeamGraphic);
                IsBeamRectangularInvisibleCheck.setSelected(true);
                GeometryPanel.setPreferredSize(new Dimension(130, 300));
                beamhfLabel.setVisible(false);
                beamhfInput.setEnabled(false);
                beamhfInput.setVisible(false);
                UnitCMHF.setVisible(false);
                beambeff1Label.setVisible(false);
                beambeff1Input.setEnabled(false);
                beambeff1Input.setVisible(false);
                UnitCMBEFF1.setVisible(false);
                beambeff2Label.setVisible(false);
                beambeff2Input.setEnabled(false);
                beambeff2Input.setVisible(false);
                UnitCMBEFF2.setVisible(false);


            }

        }


    }
}
