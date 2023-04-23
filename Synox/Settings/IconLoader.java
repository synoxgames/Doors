package Synox.Settings;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class IconLoader {

    public static ImageIcon GetIcon(String fileName) {
        try {
        Image img = ImageIO.read(IconLoader.class.getResource("img\\"+fileName));
        return new ImageIcon(img);
        } catch (Exception e) {
            return null;
        }
    }
    
}
