//Plik wywoławczy aplikacji Mały inżynier

package main.mainwindow;

import main.common.StandardGraphicParameters;

import javax.swing.*;
import java.awt.*;


public class MalyInzynier {
    //Background Color (third parameter controls brightness) and size
    static Color backgroundColor = StandardGraphicParameters.backgroundColor;

    private static void startMainWindow() {
        //Container
        JFrame MainFrame = new JFrame("Mały inżynier");
        ImageIcon AppIcon = new ImageIcon(main.mainwindow.MalyInzynier.class.getResource("/graphic/AppIcon.png"));
        MainFrame.setIconImage(AppIcon.getImage());

        //Exit on close
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Show window
        MainFrame.setVisible(true);
        //BackgroundColor
        MainFrame.getContentPane().setBackground(backgroundColor);
        //Initial window size
        MainFrame.setResizable(false);
        MainFrame.setLayout(new CardLayout());
        //MainFrame.setLocationRelativeTo(null);

        //Construct main window
        MainWindow MAIN = new MainWindow(MainFrame);
        MAIN.MainWindowContent();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startMainWindow();
            }
        });
    }
}
