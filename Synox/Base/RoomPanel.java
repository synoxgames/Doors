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
        CheckRoom(this);
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
            for (int y = 0; y < toCheck.getComponentCount(); y++) {
                int[] firstDataSet = new int[] {
                    toCheck.getComponent(i).getLocation().x, toCheck.getComponent(i).getLocation().y,
                    toCheck.getComponent(i).getSize().width, toCheck.getComponent(i).getSize().height
                };
    
                int[] secondDataSet = new int[] {
                    toCheck.getComponent(y).getLocation().x, toCheck.getComponent(y).getLocation().y,
                    toCheck.getComponent(y).getSize().width + 10, toCheck.getComponent(y).getSize().height
                };
    
                System.out.println(GameInfo.isRoomOverlap(firstDataSet, secondDataSet));
            }
        }
        return true;
    }

}