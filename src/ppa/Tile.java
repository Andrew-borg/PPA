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
    private int airID;
    
    public Tile(int x, int y, int width, int height, int groundID, int airID){
        setBounds(x, y, width, height);
        this.groundID = groundID;
        this.airID = airID;
    }
    
    public void draw(Graphics g){
        //g.drawRect(x, y, width, height);
        
        //g.drawImage(Window.groundTiles[groundID], x, y, null);
        if(groundID == 0){
            g.setColor(Color.green);
        }
        if(groundID == 1){
            g.setColor(Color.lightGray);
        }
        g.fillRect(x+1, y+1, width-2, height-2);
    }
    
    public int getGroundID(){
        return groundID;
    }
    
    public void setGroundID(int id){
        groundID = id;
    }
}
