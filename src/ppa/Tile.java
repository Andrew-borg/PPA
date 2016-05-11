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
        g.drawRect(x, y, width, height);
        
        g.drawImage(Window.groundTiles[], x, y, null);
        g.drawi
    }
}
