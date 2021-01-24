package main.mainwindow;

import javax.swing.*;
import java.awt.*;

//Tu coś jeszcze nie pyka, na razie zostawiam menu wrzucone w MainWindow, będziemy potem wydzielać.

public class MenuBar {
    //Background Color (third parameter controls brightness) and size
    static Color backgroundColor;

    //Elements requiring ActionListening
    JFrame MainFrame;

    //Constructor with colour, size and mainframe
    MenuBar(Color C, JFrame MF) {
        backgroundColor = C;
        MainFrame = MF;
    }

    public void MenuBarContent() {
        //MenuBar
        JMenuBar MenuBar = new JMenuBar();
        JMenu FileMenu = new JMenu("Plik");
        JMenu SettingMenu = new JMenu("Ustawienia");
        JMenu HelpMenu = new JMenu("Pomoc");

        MenuBar.add(FileMenu);
        MenuBar.add(SettingMenu);
        MenuBar.add(HelpMenu);

    }
}
