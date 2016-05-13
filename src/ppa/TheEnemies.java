/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class TheEnemies {
    private int enemySize = Window.map.tileSize;
    private ArrayList<Enemy> enemyList;
    private Tile spawnTile, endTile;
    private int spawnRate = 120;
    private int frameCounter = -1;
    
    public TheEnemies(Tile spawn, Tile end){
        enemyList = new ArrayList();
        
        spawnTile = spawn;
        endTile = end;
    }
    
    public void draw(Graphics g){
        for(Enemy e:enemyList){
            e.draw(g);
        }
    }
    
    public void move(){
        for(Enemy e:enemyList){
            e.move();
        }
    }
    
    public void spawn(){
        if(frameCounter == -1){
            enemyList.add(new Enemy(100, spawnTile.x, spawnTile.y, enemySize, enemySize));
        }
        if(frameCounter == spawnRate){
            enemyList.add(new Enemy(100, spawnTile.x, spawnTile.y, enemySize, enemySize));
            
            frameCounter = 0;
        }
        else{
            frameCounter++;
        }
    }
    
    public void removeDead(){
        for(Enemy e:enemyList){
            if(e.getHealth() <= 0){
                enemyList.remove(e);
            }
        }
    }
    
    public void removeCompletedPath(){
        for(int i = 0; i < enemyList.size(); i++){
            if(enemyList.get(i).getX() == endTile.x && enemyList.get(i).getY() == endTile.y){
                Window.getHurt(10);
                enemyList.remove(i);
            }
        }
    }
}
