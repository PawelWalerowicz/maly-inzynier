package main.common;

import java.awt.*;

public class StandardGraphicParameters {
    public static Color backgroundColor = Color.getHSBColor((float) 0, (float) 0, (float) 0.85);
    public static Font defaultFont = new Font(Font.DIALOG, Font.BOLD, 12);
    public static Font plainFont = new Font(Font.DIALOG, Font.PLAIN, 12);
    public static Font bigFont = new Font(Font.DIALOG, Font.BOLD, 14);
    public static int resolutionWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int resolutionHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
}
