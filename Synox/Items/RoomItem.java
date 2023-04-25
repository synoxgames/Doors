package Synox.Items;

import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class RoomItem extends JButton implements ActionListener {
    
    public Point itemPosition;

    public abstract JButton BuildPanel();

    public abstract Point GetRandomPosition();

    public void ChangePosition()  {
        itemPosition = GetRandomPosition();
    }
}
