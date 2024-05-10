package Synox.Creatures;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;

import Synox.Base.RoomItem;

public abstract class Creature extends RoomItem {

    public abstract JButton BuildPanel();
    public abstract void CreatureMovement();
    public Timer movementTimer = new Timer();
    
}
