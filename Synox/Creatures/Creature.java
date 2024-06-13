package Synox.Creatures;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

import javax.swing.JButton;

import Synox.Base.AnimatedObject;
import Synox.Base.RoomItem;

public abstract class Creature extends RoomItem implements AnimatedObject {

    public abstract JButton BuildPanel();
    public abstract void actionPerformed(ActionEvent e);
    public abstract void CreatureMovement();
    public boolean isActive = true;
    public int moveSpeed = 1;

    private int timer = 0;
    public Timer movementTimer = new Timer(timer, this);

    public void StartTimer() {
        movementTimer.start();
    }

    public void StopTimer() {
        movementTimer.stop();
    }

    public void ResetTimer() {
        movementTimer.restart();
    }

    public void SwitchState() { isActive = !isActive; }
    public void SetState(boolean state) { isActive = state; }
}
