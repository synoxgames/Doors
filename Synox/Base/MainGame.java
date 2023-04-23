package Synox.Base;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Synox.Settings.GameInfo;

public class MainGame {

    private static RoomPanel room = new RoomPanel();
    private static JFrame frame = new JFrame("Room Test");

    private static JPanel gamePanel = new JPanel();
    private static JLabel roomCountLabel = new JLabel();

    public static int currentRoomCount = 1;

    public static void main(String[] args) {
        frame.setPreferredSize(GameInfo.gameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximumSize(GameInfo.gameSize);
        frame.setResizable(false);

        room = new RoomPanel();
        gamePanel.setBackground(Color.black);
        gamePanel.setSize(GameInfo.gamePanelSize);
        gamePanel.add(room);        
        gamePanel.setLocation(64,64);
        
        roomCountLabel.setSize(128, 20);
        roomCountLabel.setLocation(((GameInfo.gameSize.width - 20)/2), 128 + (20 - roomCountLabel.getText().length()));
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
        gamePanel.revalidate();
        roomCountLabel.setLocation(((GameInfo.gameSize.width - 20)/2), 128 +20);
        roomCountLabel.setText("#"+currentRoomCount);
        roomCountLabel.revalidate();
    }

    public static void LoadPreviousRoom() {
        currentRoomCount--;
        room.PreviousRoom();
        room.revalidate();
        roomCountLabel.revalidate();
        roomCountLabel.setLocation(((GameInfo.gameSize.width - (20 - roomCountLabel.getText().length()))/2), 128 + 20);
        roomCountLabel.setText("#"+currentRoomCount);
        gamePanel.revalidate();
    }

    public static void UnlockDoor() {
        room.currentRoom.UnlockDoor();
    }

    public static int GetRandomColourVal() {
        return (int) ((Math.random() * (255)));
    }
    
}
