package main.common;

import javax.swing.*;
import java.awt.*;

public class JTools {

    public static String getJContent(JPanel panel,String name) {
        String answer="String not found!";
        Component[] LocalList = panel.getComponents();
        for (int i = 0; i < LocalList.length; i++) {
            if (LocalList[i] instanceof JTextField) {
                String InputWindowName = LocalList[i].getName();
                if (InputWindowName.equals(name)) {
                    answer = ((JTextField) LocalList[i]).getText();
                }
            } else if(LocalList[i] instanceof JComboBox) {
                String InputWindowName = LocalList[i].getName();
                if (InputWindowName.equals(name)) {
                    answer = String.valueOf(((JComboBox) LocalList[i]).getSelectedItem());
                }
            }
        }


        return answer;
    }


    public static JTextField getJComponent(JPanel panel,String name) {
        JTextField answer= new JTextField();
        Component[] LocalList = panel.getComponents();
        for (int i = 0; i < LocalList.length; i++) {
            if (LocalList[i] instanceof JTextField) {
                String InputWindowName = LocalList[i].getName();
                if (InputWindowName.equals(name)) {
                    answer = ((JTextField) LocalList[i]);
                }
            }

        }
        return answer;
    }


    public static JPanel getJPanel(JPanel panel, String name) {
        JPanel answer= new JPanel();
        Component[] LocalList = panel.getComponents();
        for (int i = 0; i < LocalList.length; i++) {
            String InputWindowName;
            if (LocalList[i] instanceof JPanel) {
                InputWindowName = LocalList[i].getName();
                if (InputWindowName.equals(name)) {
                    answer = ((JPanel) LocalList[i]);
                }
            }
        }
        return answer;
    }


    public static JLabel getJLabel(JPanel panel, String name) {
        JLabel answer= new JLabel();
        Component[] LocalList = panel.getComponents();
        for (int i = 0; i < LocalList.length; i++) {
            String InputWindowName;
            if (LocalList[i] instanceof JLabel) {
                try {
                    InputWindowName = LocalList[i].getName();
                    if (InputWindowName.equals(name)) {
                        answer = ((JLabel) LocalList[i]);
                    }
                } catch (NullPointerException exc) {
                }

            }
        }
        return answer;
    }



    public static boolean getJCheckBoxStatus(JPanel panel,String name) {
        boolean answer = false;
        Component[] LocalList = panel.getComponents();
        for (int i = 0; i < LocalList.length; i++) {
            if (LocalList[i] instanceof JCheckBox) {
                String InputWindowName = LocalList[i].getName();
                if (InputWindowName.equals(name)) {
                    answer = ((JCheckBox) LocalList[i]).isSelected();
                }
            }

        }
        return answer;
    }


}
