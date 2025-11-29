package pac;

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

    public List<Monster> getMonstersAt(int x, int y) {
        List<Monster> list = new ArrayList<>();

        for (Entity e : tiles[y][x].getEntities()) {
            if (e instanceof Monster m) list.add(m);
        }
        return list;
    }

    public void removeEntity(Entity e) {
        tiles[e.getY()][e.getX()].removeEntity(e);
    }


    public boolean movePlayer(Character player,int dx, int dy) {
        if (player == null) return false;

        int x = player.getX();
        int y = player.getY();

        int nx = x + dx;
        int ny = y + dy;

        // pályán belül?
        if (nx < 0 || ny < 0 || nx >= cols || ny >= rows) return false;

        Tile target = tiles[ny][nx];

        // fal? (pl. type==1 a wall)
        if (target.getType() == 1) return false;

        // régi tile-ról levesszük a playert
        tiles[y][x].removeEntity(player);

        // player koordináták frissítése
        player.setPos(nx,ny);

        // új tile-ra rátesszük
        target.addEntity(player);

        return true;
    }
}