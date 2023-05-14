package Synox.Base;
import java.awt.Color;
import java.util.ArrayList;

import Synox.Items.Door;

/**
 * This class is used to describe what a fundemental room should look like in the game. It can be overwritten to add custom elements, but can also be used as an empty/blank room
 */
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

    public boolean GetLockState() {
        return roomDoor.isLocked;
    }
    
    @Override
    public String toString() {
        return "BASE ROOM";
    }
}
