package Synox.Items;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Synox.Base.MainGame;
import Synox.Settings.AudioPlayer;
import Synox.Settings.GameInfo;
import Synox.Settings.IconLoader;

public class Door extends RoomItem {

    public boolean isLocked = false;
    boolean mouseIn = false;

    public Door() {
        itemPosition = GetRandomPosition();
        addActionListener(this);
    }

    public Point GetRandomPosition() {
        return new Point((int)((Math.random() * (128-14))), (int)((Math.random() * (128-26))));
    }

    @Override
    public JButton BuildPanel() {
        setIcon(IconLoader.GetIcon("Door.png"));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setLocation(itemPosition);
        setSize(GameInfo.DOOR_SIZE);
        getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel mod = (ButtonModel) e.getSource();
                if (mod.isRollover()) {
                    setIcon(isLocked ? IconLoader.GetIcon("Door_Locked.png") : IconLoader.GetIcon("Door_Hover.png"));
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    if (!mouseIn) { 
                        AudioPlayer.PlaySound(isLocked ? "DoorLocked_HVR.wav" : "Door_HVR.wav"); 
                        mouseIn = true; 
                    }
                } else if (!mod.isRollover()) {
                    setIcon(IconLoader.GetIcon("Door.png"));
                    setCursor(Cursor.getDefaultCursor());
                    mouseIn = false;
                } 
            }
        });
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isLocked) {
            MainGame.LoadNextRoom();
            AudioPlayer.PlaySound("Door_Enter.wav");
        } else {
            AudioPlayer.PlaySound("DoorLocked.wav");
        }
    }
    
}
