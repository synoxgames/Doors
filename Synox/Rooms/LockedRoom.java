package Synox.Rooms;

import Synox.Items.Button;

public class LockedRoom extends Room {

    public LockedRoom() {
        super();
        LockDoor();
        AddItem(new Button());
    }

    @Override
    public String toString() {
        return "Locked Room";
    }
    
}
