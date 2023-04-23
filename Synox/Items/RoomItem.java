package Synox.Items;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class RoomItem extends JButton implements ActionListener {
    
    public abstract JButton BuildPanel();

}
