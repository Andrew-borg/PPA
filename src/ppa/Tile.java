/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;
import javax.swing.*;


public class Tile extends Rectangle{
    private int groundID;
    private int towerID;
    private Color[] towerColors = new Color[]
    {   new Color(200, 20, 20), 
        new Color(200, 20, 20), 
        new Color(200, 20, 20)};
    
    public Tile(int x, int y, int width, int height, int groundID, int airID){
        setBounds(x, y, width, height);
        this.groundID = groundID;
        this.towerID = airID;
    }
    
    public void draw(Graphics g){
        if(groundID == 0){
            g.setColor(new Color(0, 120, 0));
        }
        if(groundID == 1){
            g.setColor(new Color(140, 140, 140));
        }
        g.fillRect(x+1, y+1, width-2, height-2);
        //color the ground
        
        //color the tower
        if(towerID != 0){
            g.setColor(towerColors[towerID-1]);
            g.fillOval(x+width/2-10, y+height/2-10, 20, 20);
        }
    }
    
    public int getGroundID(){
        return groundID;
    }
    
    public void setGroundID(int id){
        groundID = id;
    }
    
    public int getTowerID(){
        return towerID;
    }
    
    public void setTowerID(int id){
        towerID = id;
    }
}
