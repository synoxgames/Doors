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

public class ReturnDoor extends RoomItem {

    public Point doorPosition;

    public ReturnDoor() {
        doorPosition = GetRandomPosition();
        addActionListener(this);
    }

    @Override
    public JButton BuildPanel() {
        setIcon(IconLoader.GetIcon("Door_Prev.png"));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setLocation(doorPosition);
        setSize(GameInfo.RETURN_DOOR_SIZE);
        getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel mod = (ButtonModel) e.getSource();
                if (mod.isRollover()) {
                    setIcon(IconLoader.GetIcon("Door_PrevHVR.png"));
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    setIcon(IconLoader.GetIcon("Door_Prev.png"));
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        });
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainGame.LoadPreviousRoom();
    }

    @Override
    public Point GetRandomPosition() {
        return new Point((128-GameInfo.RETURN_DOOR_SIZE.width)/2, 128-GameInfo.RETURN_DOOR_SIZE.height+5);
    }
}
