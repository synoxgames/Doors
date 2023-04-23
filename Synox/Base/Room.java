package Synox.Base;
import java.awt.Color;

import Synox.Items.Door;

public class Room {

    public Door roomDoor;
    public Color roomColour;
    public Room previousRoom, nextRoom;

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
    
}
