package entities;

import java.util.List;

public class Character extends Entity {
    List<Item> inventory;
    int level;
    Character(int x, int y) {
        super(x, y);
    }
}
