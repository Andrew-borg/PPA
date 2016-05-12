/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;
import javax.swing.*;


public class Map {
    public static int mapWidth = 20;
    public static int mapHeight = 15;
    public int tileSize = 32;
    
    public static Tile[][] map;
    
    public Map(){
        map = new Tile[mapWidth][mapHeight];
        
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize, tileSize, 0, 0);
            }
        }
        LoadMap.load(map);
    }
    
    public void draw(Graphics g){
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                map[i][j].draw(g);
            }
        }
    }
    
    public static Tile[][] getMap(){
        return map;
    }
    
    private Tile getTileOfPoint(Point p){
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                if(map[i][j].contains(p)){
                    return map[i][j];
                }
            }
        }
        return new Tile(0,0,0,0,0,0);
    }
    
    public int[] getTileCoordinatesOfPoint(Point p){
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                if(map[i][j].contains(p)){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    public void placeTower(){
        if(Window.mouseClick.y < (mapHeight + 1)*tileSize
           && Window.mouseClick.x < (mapWidth + 1)*tileSize){//is mouse click in the map?
            if(getTileOfPoint(Window.mouseClick).getTowerID() == 0){//is there a tower there yet?
                if(Window.store.getCost(Window.store.getItemHeld()) <= Window.store.getGold()){//can you afford tower?
                    if(Window.store.holdingItem()){//are you actually holding anything?
                        if(getTileOfPoint(Window.mouseClick).getGroundID() == 0){//can't place tower on the road
                            getTileOfPoint(Window.mouseClick).setTowerID(Window.store.getItemHeld()+1);//build tower
                            Window.store.spendGold(Window.store.getCost(Window.store.getItemHeld()));//Pay for tower
                        }
                    }
                }
            }
        }
    }
}
