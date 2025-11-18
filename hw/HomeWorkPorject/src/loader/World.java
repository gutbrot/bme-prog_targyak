package loader;

import entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class World {
    private Tile[][] tiles;
    public int rows;
    public int cols;

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        tiles = new Tile[rows][cols];

    }

    public void addEntity(Entity e){
        int x = e.getX();
        int y = e.getY();
        tiles[x][y].addEntity(e);
    }

    public void setTileType(int x, int y, int type){
        tiles[x][y].setType(type);
    }
    public Tile[][] getTiles(){
        return tiles;
    }

    public java.util.List<Entity> getEntities(){
        List<Entity> entities = new ArrayList<>();
        for(Tile[] row: tiles) {
            for (Tile tile : row) {
                entities.addAll(tile.entities);
            }
        }
        return entities;
    }
}