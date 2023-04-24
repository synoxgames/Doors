package Synox.Settings;

import Synox.Rooms.*;
import Synox.Base.Room;
import java.awt.*;

public class GameInfo {

    public static final Dimension MAIN_GAME_SIZE = new Dimension(256, 256);
    public static final Dimension ROOM_SIZE = new Dimension(128, 128);
    public static final Dimension GAME_PANEL_SIZE = new Dimension(180, 180);
    public static final Dimension DOOR_SIZE = new Dimension(14, 26);
    public static final Dimension RETURN_DOOR_SIZE = new Dimension(42, 20);
    public static final Dimension UNLOCK_BUTTON_SIZE = new Dimension(14, 14);

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
}