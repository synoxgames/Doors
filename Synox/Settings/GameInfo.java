package Synox.Settings;

import Synox.Rooms.*;
import Synox.Base.Room;
import Synox.Items.Pickupable;

import java.awt.*;

public class GameInfo {

    public static final Dimension MAIN_GAME_SIZE = new Dimension(256, 256);
    public static final Dimension ROOM_SIZE = new Dimension(128, 128);
    public static final Dimension GAME_PANEL_SIZE = new Dimension(180, 180);
    public static final Dimension DOOR_SIZE = new Dimension(14, 26);
    public static final Dimension RETURN_DOOR_SIZE = new Dimension(42, 20);
    public static final Dimension UNLOCK_BUTTON_SIZE = new Dimension(14, 14);
    public static final Dimension KEY_SIZE = new Dimension(10, 5);

    public static Pickupable heldItem;

    public static Room GetRandomRoomType() {
        int i = (int) (((3 - 1) * Math.random()) + 1);
        switch (i) {
            case 1:
                return new BasicRoom();
            case 2:
                return new LockedRoom();
            default:
                return new BasicRoom();
        }
    }

    public static void Log(Object log) {
        System.out.println(log);
    }

    public static boolean isRoomOverlap(int[] rec1, int[] rec2) {
        boolean widthIsPositive = Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]);
        boolean heightIsPositive = Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
        return ( widthIsPositive && heightIsPositive);
    }

    public static void PickupItem(Pickupable item) {
        if (heldItem != null) {
            heldItem = item;
            item.DiscardItem();
        } else {
            GameInfo.Log("Item Already Held");
        }
    }
}