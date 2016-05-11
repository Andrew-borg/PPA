/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;
import javax.swing.*;

public class Window extends JPanel implements Runnable{
    private Thread game = new Thread(this);
    private int fps = 60;
    private long timerLast;
    private boolean isFirst = true;
    private Map map;
    
    //public static Image[] groundTiles = new Image[2];
    //public String[] ground = new String[]{"grass"};
    //public static Image[] towerImages = new Image[1];
    //public String[] tower = new String[]{"none"};
    
    public Window(){
        game.start();
    }
    
    public void paintComponent(Graphics g){
        if(isFirst){
            map = new Map();
            
            isFirst = false;
        }
        
        g.clearRect(0, 0, getWidth(), getHeight());
        
        map.draw(g);
    }
    
    public void run(){
        repaint();
        timerLast = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis() - timerLast >= 1000/fps){  //restricts game to a certain framerate
                
                
                repaint();
            }
        }
    }
}
