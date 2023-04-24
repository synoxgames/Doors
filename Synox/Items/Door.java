package Synox.Items;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Synox.Base.MainGame;
import Synox.Settings.GameInfo;
import Synox.Settings.IconLoader;

public class Door extends RoomItem {

    public boolean isLocked = false;
    public Point doorPosition;

    public Door() {
        doorPosition = GetRandomPosition();
        addActionListener(this);
    }

    public Door(Point pos) {
        doorPosition = pos;
    }

    public Point GetRandomPosition() {
        return new Point((int)((Math.random() * (128-14))), (int)((Math.random() * (128-26))));
    }

    @Override
    public JButton BuildPanel() {
        setIcon(IconLoader.GetIcon("Door.png"));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setLocation(doorPosition);
        setSize(GameInfo.DOOR_SIZE);
        getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel mod = (ButtonModel) e.getSource();
                if (mod.isRollover()) {
                    setIcon(isLocked ? IconLoader.GetIcon("Door_Locked.png") : IconLoader.GetIcon("Door_Hover.png"));
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    setIcon(IconLoader.GetIcon("Door.png"));
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        });
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isLocked) {
            MainGame.LoadNextRoom();
        }
    }
    
}
