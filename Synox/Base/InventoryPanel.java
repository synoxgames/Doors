package Synox.Base;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Synox.Settings.GameInfo;
import Synox.Settings.IconLoader;

public class InventoryPanel extends JPanel {

    public InventoryItem currentItem = null;

    public static InventoryPanel instance;

    public InventoryPanel() {
        if (instance != this) {
            instance = null;
        } 

        instance = this;
    }

    public JPanel BuildPanel() {
        removeAll();
        setLayout(null);
        setSize(GameInfo.INVENTORY_SIZE);
        setLocation(GameInfo.INVENTORY_POSITION);
        if (currentItem != null)
            add(currentItem.BuildInventoryPanel());
        
        return this;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(IconLoader.GetIcon("Inventory_Backdrop.png").getImage(), 0, 0, null);
    }

    public void PickupItem(InventoryItem item) {
        if (currentItem == null) {
            currentItem = item;
        } else return;
    }

    public boolean isInventoryFree() {
        return currentItem == null;
    }
    
}
