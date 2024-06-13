package Synox.Base;

import javax.swing.JComponent;

import java.awt.Dimension;
import java.awt.Graphics2D;

public interface AnimatedObject {
    public void update(Dimension size);
    public void paint(JComponent parent, Graphics2D g2d);
}
