package Synox.Base;
import Synox.Items.ReturnDoor;
import Synox.Items.RoomItem;
import Synox.Settings.GameInfo;

import java.awt.Point;

import javax.swing.*;

public class RoomPanel extends JPanel {

    public Room currentRoom = new Room();

    public RoomPanel() {
        currentRoom = new Room();
        DrawPanel();
    }

    public JPanel DrawPanel() {
        removeAll();
        setPreferredSize(GameInfo.ROOM_SIZE);
        setBackground(currentRoom.roomColour);
        setLayout(null);
        add(currentRoom.roomDoor.BuildPanel());
        if (currentRoom.previousRoom != null) {
            ReturnDoor returnDoor = new ReturnDoor();
            add(returnDoor.BuildPanel());
        }

        if (!currentRoom.roomItems.isEmpty()) {
            for (RoomItem item : currentRoom.roomItems) {
                add(item.BuildPanel());
            }
        }

        revalidate();

        if (!CheckRoom(this)) {
            currentRoom.roomDoor.ChangePosition();
            if (!currentRoom.roomItems.isEmpty()) {
                for (RoomItem item : currentRoom.roomItems) {
                    item.ChangePosition();
                }
            }
            DrawPanel();
        }

        return this;
    }

    public void NextRoom() {
        if (currentRoom.nextRoom == null) {
            Room nextRoom = GameInfo.GetRandomRoomType();
            nextRoom.previousRoom = currentRoom;
            currentRoom.nextRoom = nextRoom;
            currentRoom = nextRoom;
        } else if (currentRoom.nextRoom != null) {
            currentRoom = currentRoom.nextRoom;
        }
        DrawPanel();
    }

    public void PreviousRoom() {
        currentRoom = currentRoom.previousRoom;
        DrawPanel();
    }

    public boolean CheckRoom(JPanel toCheck) {
        if (toCheck.getComponentCount() <= 1) return true;

        for (int i = 0; i < toCheck.getComponentCount(); i++) {
            Point dataOnePos = toCheck.getComponent(i).getLocation();
            for (int y = 0; y < toCheck.getComponentCount(); y++) {
                if (y == i) continue;
                Point dataTwoPos = toCheck.getComponent(y).getLocation();

                int[] firstDataSet = new int[] {
                    dataOnePos.x, dataOnePos.y,
                    toCheck.getComponent(i).getSize().width + dataOnePos.x, toCheck.getComponent(i).getSize().height + dataOnePos.y
                };
    
                int[] secondDataSet = new int[] {
                    dataTwoPos.x, dataTwoPos.y,
                    toCheck.getComponent(y).getSize().width + dataTwoPos.x, toCheck.getComponent(y).getSize().height + dataTwoPos.y
                };
    
                if (GameInfo.isRoomOverlap(firstDataSet, secondDataSet))  {
                    return false;
                }
            }
        }
        return true;
    }

}