package Synox.Base;
import Synox.Items.ReturnDoor;
import Synox.Settings.GameInfo;

import java.awt.Point;

import javax.swing.*;

/**
 * This is used to draw a room to a JPanel
 */
public class RoomPanel extends JPanel {

    public Room currentRoom = new Room();       // This is the current room that is being drawn

    public RoomPanel() {
        currentRoom = new Room();
        setPreferredSize(GameInfo.ROOM_SIZE);
        DrawPanel();
    }

    /**
     * This will be used for drawing the JPanel, once it has been called it will also check to see if the room is valid (i.e, has no overlaps)
     * @return The drawn room panel
     */
    public JPanel DrawPanel() {
        // Removing anything on the panel and set it all up again
        removeAll();
        setBackground(currentRoom.roomColour);
        setLayout(null);
        add(currentRoom.roomDoor.BuildPanel());

        if (currentRoom.previousRoom != null) {
            ReturnDoor returnDoor = new ReturnDoor();   // Only put a return door if we have a previous room to go back to
            add(returnDoor.BuildPanel());
        }

        if (!currentRoom.roomItems.isEmpty()) {
            for (RoomItem item : currentRoom.roomItems) {
                add(item.BuildPanel());
            }
        }

        revalidate();

        // Check to see if the room is valid
        if (!CheckRoom(this)) {
            currentRoom.roomDoor.ChangePosition();
            if (!currentRoom.roomItems.isEmpty()) {
                for (RoomItem item : currentRoom.roomItems) {
                    // If it isn't valid then swap around the items positions
                    item.ChangePosition();
                }
            }
            // Redraw and recheck panel until it is clear
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

    /**
     * This is used to check if any components of a JPanel are touching
     * @param toCheck The JPanel to check
     * @return A boolean on whether any components overlap
     */
    public boolean CheckRoom(JPanel toCheck) {
        if (toCheck.getComponentCount() <= 1) return true;  // If there's 0 or 1 item just return true since nothing can overlap

        
        for (int i = 0; i < toCheck.getComponentCount(); i++) {             // Loop through each of the componenets
            Point dataOnePos = toCheck.getComponent(i).getLocation();       // Get the position of the current component
            for (int y = 0; y < toCheck.getComponentCount(); y++) {         // Loop through each of the components again
                if (y == i) continue;                                       
                Point dataTwoPos = toCheck.getComponent(y).getLocation();   // Get the position of the other component

                // Store x1, y1, x2, y2 of the first component
                int[] firstDataSet = new int[] {
                    dataOnePos.x, dataOnePos.y,
                    toCheck.getComponent(i).getSize().width + dataOnePos.x, toCheck.getComponent(i).getSize().height + dataOnePos.y
                };
    
                // Store x1, y1, x2, y2 of the second component
                int[] secondDataSet = new int[] {
                    dataTwoPos.x, dataTwoPos.y,
                    toCheck.getComponent(y).getSize().width + dataTwoPos.x, toCheck.getComponent(y).getSize().height + dataTwoPos.y
                };
    
                // Check the stored data of both points and return false if there are any overlaps
                if (GameInfo.isRoomOverlap(firstDataSet, secondDataSet))  {
                    GameInfo.Log("Overlap Found, Redrawing room!");
                    return false;
                }
            }
        }

        // If we got here, there were no overlaps so return true
        return true;
    }

}