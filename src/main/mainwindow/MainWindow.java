package main.mainwindow;

import main.concrete.concreteinterface.ConcreteWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static main.common.StandardGraphicParameters.*;

public class MainWindow implements ActionListener {
    //Background Color (third parameter controls brightness) and size
    static Color buttonBackgroundColor = Color.WHITE;

    static int buttonWidth = 125;
    static int buttonHight = 125;
    static int buttonGap = 25;
    static int windowWidth = 5 * buttonGap + 4 * buttonWidth;
    static int windowHight = 100 + 2 * buttonGap + buttonHight;

    static Dimension defaultButtonSize = new Dimension(buttonWidth, buttonHight);
    static Font headerFont = new Font(Font.DIALOG, Font.BOLD, 20);

    //Elements requiring ActionListening
    JButton ConcreteButton;
    JButton SteelButton;
    JButton WoodButton;
    JButton FEMButton;
    JPanel MainWindow;
    JFrame MainFrame;

    //Constructor with colour, size and mainframe
    public MainWindow(JFrame MF) {

        MainFrame = MF;
    }

    public void MainWindowContent() {
        //Resizing MainFrame
        MainFrame.setSize(windowWidth, windowHight);
        //MainWindow elements
        MainWindow = new JPanel();
        SpringLayout MainWindowLayout = new SpringLayout();
        MainWindow.setLayout(MainWindowLayout);
        MainWindow.setBackground(backgroundColor);

        MainFrame.setLocation((resolutionWidth - windowWidth) / 2, (resolutionHeight - windowHight) / 2);

        //MenuBar
        JMenuBar MenuBar = new JMenuBar();
        JMenu FileMenu = new JMenu("Plik");
        JMenu SettingMenu = new JMenu("Ustawienia");
        JMenu HelpMenu = new JMenu("Pomoc");

        MenuBar.add(FileMenu);
        MenuBar.add(SettingMenu);
        MenuBar.add(HelpMenu);

        //Welcome Label
        JLabel ChooseSubWindow = new JLabel("Wybierz zestaw narzędzi:");
        ChooseSubWindow.setFont(headerFont);

        //Pane Buttons

        //Concrete Button
        ConcreteButton = new JButton("Belki żelbetowe");
        ConcreteButton.addActionListener(this);
        ConcreteButton.setToolTipText("<html>"
                + "Przejdź do wymiarowania przekrojów belek żelbetowych."
                + "<br>"
                + "Skrót klawiszowy: Alt+1"
                + "</html>");
        ImageIcon TBeamGraphic = new ImageIcon(this.getClass().getResource("/graphic/TBeam.png"));
        ConcreteButton.setIcon(TBeamGraphic);
        ConcreteButton.setPreferredSize(defaultButtonSize);
        ConcreteButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        ConcreteButton.setHorizontalTextPosition(AbstractButton.CENTER);
        ConcreteButton.setMnemonic(KeyEvent.VK_1);
        ConcreteButton.setBackground(buttonBackgroundColor);

        //Steel Button
        SteelButton = new JButton("Belki stalowe");
        SteelButton.addActionListener(this);
        SteelButton.setToolTipText("<html>"
                + "Przejdź do wymiarowania belek stalowych."
                + "<br>"
                + "Skrót klawiszowy: Alt+2"
                + "<br>"
                + "Funkcja w opracowaniu."
                + "</html>");
        ImageIcon SteelGraphic = new ImageIcon(this.getClass().getResource("/graphic/Steel.png"));
        SteelButton.setIcon(SteelGraphic);
        SteelButton.setPreferredSize(defaultButtonSize);
        SteelButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        SteelButton.setHorizontalTextPosition(AbstractButton.CENTER);
        SteelButton.setMnemonic(KeyEvent.VK_2);
        SteelButton.setBackground(buttonBackgroundColor);
        // SteelButton.setEnabled(false);

        //Wood Button
        WoodButton = new JButton("Belki drewniane");
        WoodButton.addActionListener(this);
        WoodButton.setToolTipText("<html>"
                + "Przejdź do wymiarowania belek drewnianych."
                + "<br>"
                + "Skrót klawiszowy: Alt+3"
                + "<br>"
                + "Funkcja w opracowaniu."
                + "</html>");
        ImageIcon WoodGraphic = new ImageIcon(this.getClass().getResource("/graphic/Wood.png"));
        WoodButton.setIcon(WoodGraphic);
        WoodButton.setPreferredSize(defaultButtonSize);
        WoodButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        WoodButton.setHorizontalTextPosition(AbstractButton.CENTER);
        WoodButton.setMnemonic(KeyEvent.VK_3);
        WoodButton.setBackground(buttonBackgroundColor);
        //WoodButton.setEnabled(false);

        //FEM Button
        FEMButton = new JButton("Statyka");
        FEMButton.addActionListener(this);
        FEMButton.setToolTipText("<html>"
                + "Przejdź do modułu MES."
                + "<br>"
                + "Skrót klawiszowy: Alt+4"
                + "<br>"
                + "Funkcja w opracowaniu."
                + "</html>");
        ImageIcon FEMGraphic = new ImageIcon(this.getClass().getResource("/graphic/FEM.png"));
        FEMButton.setIcon(FEMGraphic);
        FEMButton.setPreferredSize(defaultButtonSize);
        FEMButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        FEMButton.setHorizontalTextPosition(AbstractButton.CENTER);
        FEMButton.setMnemonic(KeyEvent.VK_4);
        FEMButton.setBackground(buttonBackgroundColor);
        //FEMButton.setEnabled(false);


        MainWindow.add(ChooseSubWindow);
        MainWindow.add(ConcreteButton);
        MainWindow.add(SteelButton);
        MainWindow.add(WoodButton);
        MainWindow.add(FEMButton);

        //Setting location of buttons in MainWindow
        {

            //Location of ChooseSubWindow
            MainWindowLayout.putConstraint(
                    SpringLayout.HORIZONTAL_CENTER, ChooseSubWindow,
                    0,
                    SpringLayout.HORIZONTAL_CENTER, MainWindow);

            MainWindowLayout.putConstraint(
                    SpringLayout.NORTH, ChooseSubWindow,
                    10,
                    SpringLayout.NORTH, MainWindow);

            //Location of ConcreteButton
            MainWindowLayout.putConstraint(
                    SpringLayout.HORIZONTAL_CENTER, ConcreteButton,
                    (buttonGap + buttonWidth / 2),
                    SpringLayout.WEST, MainWindow);

            MainWindowLayout.putConstraint(
                    SpringLayout.NORTH, ConcreteButton,
                    buttonGap,
                    SpringLayout.SOUTH, ChooseSubWindow);

            //Location of SteelButton
            MainWindowLayout.putConstraint(
                    SpringLayout.HORIZONTAL_CENTER, SteelButton,
                    (2 * buttonGap + buttonWidth * 3 / 2),
                    SpringLayout.WEST, MainWindow);

            MainWindowLayout.putConstraint(
                    SpringLayout.NORTH, SteelButton,
                    buttonGap,
                    SpringLayout.SOUTH, ChooseSubWindow);

            //Location of WoodButton
            MainWindowLayout.putConstraint(
                    SpringLayout.HORIZONTAL_CENTER, WoodButton,
                    (3 * buttonGap + buttonWidth * 5 / 2),
                    SpringLayout.WEST, MainWindow);

            MainWindowLayout.putConstraint(
                    SpringLayout.NORTH, WoodButton,
                    buttonGap,
                    SpringLayout.SOUTH, ChooseSubWindow);

            //Location of FEMButton
            MainWindowLayout.putConstraint(
                    SpringLayout.HORIZONTAL_CENTER, FEMButton,
                    (4 * buttonGap + buttonWidth * 7 / 2),
                    SpringLayout.WEST, MainWindow);

            MainWindowLayout.putConstraint(
                    SpringLayout.NORTH, FEMButton,
                    buttonGap,
                    SpringLayout.SOUTH, ChooseSubWindow);
        }

        //Adding elements to the source frame
        MainFrame.setJMenuBar(MenuBar);
        MainFrame.add(MainWindow);
        MainWindow.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Object SourceButton = ae.getSource();
        if (SourceButton == ConcreteButton) {
            MainWindow.setVisible(false);
            MainFrame.remove(MainWindow);
            main.concrete.concreteinterface.ConcreteWindow CONC = new ConcreteWindow(MainFrame, MainWindow);
            CONC.ConcreteWindowContent();
        }
    }


}
