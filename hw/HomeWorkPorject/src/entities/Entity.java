package entities;

public class Entity {
    int id;
    String name;
    int xPos, yPos;
    int hp, maxHp;
    int atk;
    int def;
    int speed;
    boolean isDead;

    public Entity(String name, int xPosition, int yPosition) {
        this.name = name;
        this.xPos = xPosition;
        this.yPos = yPosition;
    }
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
}
