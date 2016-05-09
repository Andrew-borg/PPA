/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;
import javax.swing.*;


public class Map {
    private int mapWidth = 15;
    private int mapHeight = 10;
    private int tileSize = 32;
    
    private Tile[][] map;
    
    public Map(){
        map = new Tile[mapWidth][mapHeight];
        
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                map[i][j] = new Tile();
            }
        }
    }
    
    public void draw(Graphics g){
        
    }
}
