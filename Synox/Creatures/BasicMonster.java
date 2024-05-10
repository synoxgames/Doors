package Synox.Creatures;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Timer;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Synox.Settings.AudioPlayer;
import Synox.Settings.GameInfo;
import Synox.Settings.IconLoader;

public class BasicMonster extends Creature {

    public final Dimension MonsterSize = new Dimension(8,8);
    public float moveTimer = 0.5f;

    public BasicMonster() {
        addActionListener(this);
        itemPosition = GetRandomPosition();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public JButton BuildPanel() {
        setIcon(IconLoader.GetIcon("BasicMonster.png"));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setLocation(itemPosition);
        setSize(MonsterSize);
        CreatureMovement();
        return this;
    }

    @Override
    public void CreatureMovement() {
    }

    @Override
    public Point GetRandomPosition() {
        return new Point((int)((Math.random() * (128-8))), (int)((Math.random() * (128-8))));
    }
    
}
