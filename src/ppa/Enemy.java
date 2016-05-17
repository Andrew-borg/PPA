package ppa;

import java.awt.Point;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy extends Rectangle {
    //private Tile[][] grid; No longer used

    public int distanceTraveled = 0;
    private int direction = 0;
    /*1 = right
     2 = down
     3 = left
     4 = up*/
    private final double edecider = Math.random();

    private int health;
    private int speed = 1;//speed is in frames between movements
    private int distancePerMovement = 8;//must evenly divide 32
    private int frameCounter = 0;
    
    public int killReward = 5;

    public Enemy(int health, /*Tile[][] grid,*/ int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        //this.grid = grid; No longer used
        this.health = health;
    }

    public void move() {
        if (distanceTraveled % Window.map.tileSize == 0) {//only check when centered on a tile
            /* No longer used
             if(x+1 < PPAFrame.size.height
             && Window.map.getTileCoordinatesOfPoint(x+Window.map.tileSize, y) != null//if goal would be a tile on grid
             && Window.map.getTileOfPoint(new Point(x+Window.map.tileSize, y)).getGroundID() == 1//if goal is a road tile
             && direction != 3){
             direction = 1;
             }
             else if(y+1 < PPAFrame.size.height
             && Window.map.getTileCoordinatesOfPoint(x, y+Window.map.tileSize) != null//if goal would be a tile on grid
             && Window.map.getTileOfPoint(new Point(x, y+Window.map.tileSize)).getGroundID() == 1//if goal is a road tile
             && direction != 4){
             direction = 2;
             }
             else if(x-1 < PPAFrame.size.height
             && Window.map.getTileCoordinatesOfPoint(x-Window.map.tileSize, y) != null//if goal would be a tile on grid
             && Window.map.getTileOfPoint(new Point(x-Window.map.tileSize, y)).getGroundID() == 1//if goal is a road tile
             && direction != 1){
             direction = 3;
             }
             else if(y-1 < PPAFrame.size.height
             && Window.map.getTileCoordinatesOfPoint(x, y-Window.map.tileSize) != null//if goal would be a tile on grid
             && Window.map.getTileOfPoint(new Point(x, y-Window.map.tileSize)).getGroundID() == 1//if goal is a road tile
             && direction != 2){
             direction = 4;
             } No longer used
             */
            direction = Window.map.getTileOfPoint(new Point(x, y)).walkDirection;
        }
        if (frameCounter == speed) {
            if (direction == 1) {
                x += distancePerMovement;
                distanceTraveled += distancePerMovement;
            } else if (direction == 2) {
                y += distancePerMovement;
                distanceTraveled += distancePerMovement;
            } else if (direction == 3) {
                x -= distancePerMovement;
                distanceTraveled += distancePerMovement;
            } else if (direction == 4) {
                y -= distancePerMovement;
                distanceTraveled += distancePerMovement;
            }
            frameCounter = 0;
        } else {
            frameCounter++;
        }
    }

    public int damage(int d) {
        health -= d;
        return health;
    }

    public void draw(Graphics g) {

        BufferedImage img = null;
        if (edecider < .5) {
            try {
                img = ImageIO.read(new File("C:\\Users\\" + PPAFrame.user + "\\Documents\\NetBeansProjects\\PPA\\src\\ppa\\Donald.jpg"));
            } catch (IOException e) {
            }
        }
        if (edecider > .5) {
            try {
                img = ImageIO.read(new File("C:\\Users\\" + PPAFrame.user + "\\Documents\\NetBeansProjects\\PPA\\src\\ppa\\Jeb.png"));
            } catch (IOException e) {
            }
        }
        g.fillRect(x, y, width, height);
        g.drawImage(img, x + 1, y + 1, null);

    }

    public int getHealth() {
        return health;
    }

    /*  No longer used
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
     */
}
