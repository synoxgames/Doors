package Synox.Settings;
import java.awt.*;

public class GameInfo {

    
    public static final Dimension gameSize = new Dimension(256, 256);
    public static final Dimension roomSize = new Dimension(128, 128);
    public static final Dimension gamePanelSize = new Dimension(180, 180);
    public static final Dimension doorSize = new Dimension(14, 26);
    public static final Dimension returnDoor = new Dimension(42, 20);

    public static void Log(String log) {
        System.out.println(log);
    }

}