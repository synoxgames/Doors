package Synox.Rooms;

import Synox.Creatures.BasicMonster;

public class MonsterRoom extends Room {

    public MonsterRoom() {
        super();
        AddItem(new BasicMonster());
    }

    public String toString() {
        return "Monster Room";
    }
    
}
