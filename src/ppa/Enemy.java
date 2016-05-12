package ppa;

import java.awt.Point;
import java.awt.*;

public class Enemy extends Rectangle{
    private Tile[][] grid;
    private int temp=1;
    /*1 = Left
    2 = Right
    3 = Up
    4 = Down*/
    private int x,y, health, speed;
    private int direction;
    
    
    public Enemy(int health, Tile[][] grid, int x, int y, int width, int height){
        setBounds(x, y, width, height);
        this.grid = grid;
        this.health = health;
     
    }
    
    public Tile getDirection(){
        if(x>0 && grid[x-1][y].getGroundID()==0 && temp != 2){
            Window.map.getTileCoordinatesOfPoint(new Point(x,y));
            temp = 1;
            x--;
            return grid[x][y];
        }
        if(x<grid.length && grid[x+1][y].getGroundID()==0 && temp != 1){
            temp = 2;
            x++;
            return grid[x][y];
        }
        if(y>0 && grid[x][y-1].getGroundID()==0 && temp != 4){
            temp = 3;
            y--;
            return grid[x][y];
        }
        if(y<grid[x].length && grid[x][y+1].getGroundID()==0 && temp != 3){
            temp = 4;
            y++;
            return grid[x][y];
        }
        return null;
    }
    
    public int damage(int d){
        health=health-d;
        return health;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
    
    public Tile getPosition(){
        return grid[x][y];
    }
    
}
