package Synox.Base;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Synox.Settings.GameInfo;
import Synox.Settings.IconLoader;

public class MainGame {

    private static RoomPanel room = new RoomPanel();
    private static JFrame frame = new JFrame("Room Test");

    private static JPanel gamePanel = new JPanel();
    private static JLabel roomCountLabel = new JLabel();

    public static int currentRoomCount = 1;

    public static void main(String[] args) {
        frame.setPreferredSize(GameInfo.MAIN_GAME_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximumSize(GameInfo.MAIN_GAME_SIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(IconLoader.GetIcon("GameIcon.png").getImage());

        room = new RoomPanel();
        gamePanel.setBackground(Color.black);
        gamePanel.setSize(GameInfo.GAME_PANEL_SIZE);
        gamePanel.add(room);        
        gamePanel.setLocation(64,64);

        roomCountLabel = new JLabel("#1", SwingConstants.CENTER);
        
        roomCountLabel.setSize(128, 20);
        roomCountLabel.setLocation((128 / 2) - 2 * String.valueOf(currentRoomCount).length(),140);
        roomCountLabel.setText("#"+currentRoomCount);
        roomCountLabel.setForeground(Color.white);

        frame.add(roomCountLabel);
        frame.add(gamePanel);
        frame.pack();
        frame.validate();
        frame.setVisible(true);
    }

    public static void LoadNextRoom() {
        currentRoomCount++;
        room.NextRoom();
        room.revalidate();
        roomCountLabel.setLocation((128 / 2) - 2 * String.valueOf(currentRoomCount).length(),140);
        roomCountLabel.setText("#"+currentRoomCount);
        gamePanel.revalidate();
        roomCountLabel.revalidate();
    }

    public static void LoadPreviousRoom() {
        currentRoomCount--;
        room.PreviousRoom();
        room.revalidate();
        roomCountLabel.setLocation((128 / 2) - 2 * String.valueOf(currentRoomCount).length(),140);
        roomCountLabel.setText("#"+currentRoomCount);
        roomCountLabel.revalidate();
        gamePanel.revalidate();
    }

    public static void UnlockDoor() {
        room.currentRoom.UnlockDoor();
    }

    public static int GetRandomColourVal() {
        return (int) ((Math.random() * (255)));
    }
    
}
