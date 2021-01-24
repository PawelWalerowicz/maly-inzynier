package main.concrete.concreteinterface;

import javax.swing.*;
import java.awt.*;

import static main.common.StandardGraphicParameters.*;

public class ForcesFrame {
    JFrame MainFrame;
    JPanel ConcreteWindow;
    JPanel ForcesPanel;

    public ForcesFrame(JFrame MF, JPanel CW) {
        MainFrame = MF;
        ConcreteWindow = CW;
    }

    public JPanel ForcesFrameContent(JPanel CW) {
        ConcreteWindow = CW;

        //Forces Panel
        ForcesPanel = new JPanel();
        ForcesPanel.setName("ForcesPanel");
        ForcesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Siły", 0, 0, plainFont));
        ForcesPanel.setPreferredSize(new Dimension(260, 100));
        ForcesPanel.setBackground(backgroundColor);
        SpringLayout ForcesPanelLayout = new SpringLayout();
        ForcesPanel.setLayout(ForcesPanelLayout);
        ConcreteWindow.add(ForcesPanel);

        //MEd
        JLabel MEdLabel = new JLabel("M.Ed=");
        ForcesPanel.add(MEdLabel);
        JTextField MEdInput = new JTextField("0", 3);
        MEdInput.setToolTipText("<html>"
                + "Podaj moment obliczeniowy"
                + "<br>"
                + "(wartość dodania - rozciągający zbrojenie dolne)"
                + "</html>");
        MEdInput.setHorizontalAlignment(SwingConstants.RIGHT);
        MEdInput.setFont(bigFont);
        MEdInput.setName("MEd");
        ForcesPanel.add(MEdInput);
        JLabel UnitkNmMEd = new JLabel("kNm");
        ForcesPanel.add(UnitkNmMEd);


        //Location of MEd package
        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, MEdLabel,
                5,
                SpringLayout.WEST, ForcesPanel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.NORTH, MEdLabel,
                5,
                SpringLayout.NORTH, ForcesPanel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, MEdInput,
                1,
                SpringLayout.EAST, MEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, MEdInput,
                0,
                SpringLayout.SOUTH, MEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, UnitkNmMEd,
                0,
                SpringLayout.EAST, MEdInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitkNmMEd,
                0,
                SpringLayout.SOUTH, MEdInput);

        //VEd
        JLabel VEdLabel = new JLabel("V.Ed=");
        ForcesPanel.add(VEdLabel);
        JTextField VEdInput = new JTextField("0", 3);
        VEdInput.setToolTipText("Podaj wartość obliczeniową siły poprzecznej");
        VEdInput.setHorizontalAlignment(SwingConstants.RIGHT);
        VEdInput.setFont(bigFont);
        VEdInput.setName("VEd");
        ForcesPanel.add(VEdInput);
        JLabel UnitkNVEd = new JLabel("kN");
        ForcesPanel.add(UnitkNVEd);


        //Location of Ved package
        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, VEdLabel,
                0,
                SpringLayout.WEST, MEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.NORTH, VEdLabel,
                10,
                SpringLayout.SOUTH, MEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, VEdInput,
                0,
                SpringLayout.WEST, MEdInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, VEdInput,
                0,
                SpringLayout.SOUTH, VEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, UnitkNVEd,
                0,
                SpringLayout.EAST, VEdInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitkNVEd,
                0,
                SpringLayout.SOUTH, VEdInput);


        //TEd
        JLabel TEdLabel = new JLabel("T.Ed=");
        ForcesPanel.add(TEdLabel);
        JTextField TEdInput = new JTextField("0", 3);
        TEdInput.setToolTipText("Podaj wartość obliczeniową momentu skręcającego");
        TEdInput.setHorizontalAlignment(SwingConstants.RIGHT);
        TEdInput.setFont(bigFont);
        TEdInput.setName("TEd");
        ForcesPanel.add(TEdInput);
        JLabel UnitkNmTEd = new JLabel("kNm");
        ForcesPanel.add(UnitkNmTEd);


        //Location of Ted package
        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, TEdLabel,
                0,
                SpringLayout.WEST, VEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.NORTH, TEdLabel,
                10,
                SpringLayout.SOUTH, VEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, TEdInput,
                0,
                SpringLayout.WEST, MEdInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, TEdInput,
                0,
                SpringLayout.SOUTH, TEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, UnitkNmTEd,
                0,
                SpringLayout.EAST, TEdInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitkNmTEd,
                0,
                SpringLayout.SOUTH, TEdInput);


        //MEk
        JLabel MEkLabel = new JLabel("M.Ek=");
        ForcesPanel.add(MEkLabel);
        JTextField MEkInput = new JTextField("0", 3);
        MEkInput.setToolTipText("<html>"
                + "Podaj moment charakterystyczny"
                + "<br>"
                + "(wartość dodania - rozciągający zbrojenie dolne)"
                + "</html>");
        MEkInput.setHorizontalAlignment(SwingConstants.RIGHT);
        MEkInput.setFont(bigFont);
        MEkInput.setName("MEk");
        ForcesPanel.add(MEkInput);
        JLabel UnitkNmMEk = new JLabel("kNm");
        ForcesPanel.add(UnitkNmMEk);


        //Location of MEk package
        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, MEkLabel,
                20,
                SpringLayout.EAST, UnitkNmMEd);

        ForcesPanelLayout.putConstraint(
                SpringLayout.NORTH, MEkLabel,
                0,
                SpringLayout.NORTH, MEdLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, MEkInput,
                1,
                SpringLayout.EAST, MEkLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, MEkInput,
                0,
                SpringLayout.SOUTH, MEkLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, UnitkNmMEk,
                0,
                SpringLayout.EAST, MEkInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitkNmMEk,
                0,
                SpringLayout.SOUTH, MEkInput);

        //VEk
        JLabel VEkLabel = new JLabel("V.Ek=");
        ForcesPanel.add(VEkLabel);
        JTextField VEkInput = new JTextField("0", 3);
        VEkInput.setToolTipText("Podaj wartość charakterystyczną siły poprzecznej");
        VEkInput.setHorizontalAlignment(SwingConstants.RIGHT);
        VEkInput.setFont(bigFont);
        VEkInput.setName("VEk");
        ForcesPanel.add(VEkInput);
        JLabel UnitkNVEk = new JLabel("kN");
        ForcesPanel.add(UnitkNVEk);


        //Location of Vek package
        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, VEkLabel,
                0,
                SpringLayout.WEST, MEkLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.NORTH, VEkLabel,
                10,
                SpringLayout.SOUTH, MEkLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, VEkInput,
                0,
                SpringLayout.WEST, MEkInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, VEkInput,
                0,
                SpringLayout.SOUTH, VEkLabel);

        ForcesPanelLayout.putConstraint(
                SpringLayout.WEST, UnitkNVEk,
                0,
                SpringLayout.EAST, VEkInput);

        ForcesPanelLayout.putConstraint(
                SpringLayout.SOUTH, UnitkNVEk,
                0,
                SpringLayout.SOUTH, VEkInput);


        return ForcesPanel;
    }
}
