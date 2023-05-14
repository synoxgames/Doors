package Synox.Items;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import Synox.Base.InventoryItem;
import Synox.Base.InventoryPanel;

public class Key extends InventoryItem {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!inInventory) {
            PickupItem();   
        } else if (inInventory) InventoryAction();
    }

    @Override
    public void InventoryAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InventoryAction'");
    }

    @Override
    public JPanel BuildInventoryPanel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuildInventoryPanel'");
    }

    @Override
    public void PickupItem() {
        if (InventoryPanel.instance.isInventoryFree()) {
            InventoryPanel.instance.PickupItem(this);
        }
    }

    @Override
    public JButton BuildPanel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BuildPanel'");
    }

    @Override
    public Point GetRandomPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetRandomPosition'");
    }
    
}
