package Synox.Base;

import javax.swing.JPanel;

public abstract class InventoryItem extends RoomItem {

    public boolean inInventory = false;

    
    public abstract void InventoryAction();
    public abstract JPanel BuildInventoryPanel();
    public abstract void PickupItem();

}