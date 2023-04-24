package Synox.Base;
import Synox.Items.ReturnDoor;
import Synox.Items.RoomItem;
import Synox.Settings.GameInfo;
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

}