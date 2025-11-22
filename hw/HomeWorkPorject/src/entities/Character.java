package entities;

import java.util.List;
class   Item{}
public class Character extends Entity {
    List<Item> inventory;
    int level;
    public Character(String name, int xPosition, int yPosition) {
        super(name, xPosition, yPosition);
    }
    public void setName(String name){
        this.name = name;
    }
}
