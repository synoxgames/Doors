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

public class Button extends RoomItem {

    public boolean hideButton = false;

    public Button() {
        addActionListener(this);
        itemPosition = GetRandomPosition();
        hideButton = MainGame.currentRoomCount % 2 == 0;
    }

    // magnium dong
    @Override
    public void actionPerformed(ActionEvent e) {
        MainGame.UnlockDoor();
        AudioPlayer.PlaySound("DoorUnlocked.wav");
    }

    @Override
    public JButton BuildPanel() {
        setSize(GameInfo.UNLOCK_BUTTON_SIZE);
        setLocation(itemPosition);
        setIcon(hideButton ? null : IconLoader.GetIcon("Button.png"));
        setBorderPainted(false);
        setContentAreaFilled(false);
        getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel mod = (ButtonModel) e.getSource();
                if (mod.isRollover()) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    setIcon(IconLoader.GetIcon("Button_HVR.png"));
                } else {
                    setIcon(hideButton ? null : IconLoader.GetIcon("Button.png"));
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        });
        return this;
    }

    public Point GetRandomPosition() {
        return new Point((int)((Math.random() * (128-14))), (int)((Math.random() * (128-14))));
    }
}
