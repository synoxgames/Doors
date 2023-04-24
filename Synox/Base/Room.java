package Synox.Base;
import java.awt.Color;
import java.util.ArrayList;

import Synox.Items.Door;
import Synox.Items.RoomItem;

public class Room {

    public Door roomDoor;
    public Color roomColour;
    public Room previousRoom, nextRoom;
    public ArrayList<RoomItem> roomItems = new ArrayList<RoomItem>();

    public Room() {
        roomColour = new Color(GetRandomColourVal(), GetRandomColourVal(), GetRandomColourVal());
        roomDoor = new Door();
    }

    public Color GetRoomColour() {
        return roomColour;
    }

    public int GetRandomColourVal() {
        return (int) ((Math.random() * (255)));
    }

    public void LockDoor() {
        roomDoor.isLocked = true;
    }

    public void UnlockDoor() {
        roomDoor.isLocked = false;
    }

    public void AddItem(RoomItem toAdd) {
        roomItems.add(toAdd);
    }
    
    @Override
    public String toString() {
        return "BASE ROOM";
    }
}
