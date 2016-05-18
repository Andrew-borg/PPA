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
    public static ArrayList<Enemy> enemyList;
    private Tile spawnTile, endTile;
    private int spawnRate = 120;
    private int towersPerDificultyChange = 7;
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
        if(frameCounter == spawnRate / (1+(2*Map.towersOnMap / towersPerDificultyChange))){
            enemyList.add(new Enemy(100, spawnTile.x, spawnTile.y, enemySize, enemySize));
            
            frameCounter = 0;
        }
        else{
            frameCounter++;
        }
    }
    
    public void removeDead(){
        for(int i = 0; i < enemyList.size(); i++){
            Enemy e = enemyList.get(i);
            if(e.getHealth() <= 0){
                Window.store.addGold(e.killReward);
                e = null; // so retargeting works properly
                enemyList.remove(i);
            }
        }
    }
    
    public void removeCompletedPath(){
        for(int i = 0; i < enemyList.size(); i++){
            if(Window.map.getTileOfPoint(new Point(enemyList.get(i).x, enemyList.get(i).y)).walkDirection == 5){
                Window.getHurt(10);
                enemyList.remove(i);
            }
        }
    }
}
