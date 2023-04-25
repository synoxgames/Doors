package Synox.Rooms;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import Synox.Base.MainGame;
import Synox.Items.Pickupable;
import Synox.Items.RoomItem;
import Synox.Settings.GameInfo;

public class Key extends RoomItem implements Pickupable {

    public boolean isHeld = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void PickupItem() {
        GameInfo.PickupItem(this);
    }

    @Override
    public void UseItem() {
        
    }

    @Override
    public void DiscardItem() {
    
    }

    @Override
    public JButton BuildPanel() {
        setSize(GameInfo.KEY_SIZE);
        setLocation(itemPosition);
        return this;
    }

    @Override
    public Point GetRandomPosition() {
        return new Point((128-GameInfo.KEY_SIZE.width)/2, 128-GameInfo.KEY_SIZE.height);
    }
    
}
