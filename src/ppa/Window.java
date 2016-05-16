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
    private int fps = 120;
    private long timerLast;
    private boolean isFirst = true;
    public static Map map;
    public static Store store;
    public static TheEnemies enemies;
    private int startX = 0, endX = 19;
    private int startY = 0, endY = 5;
    private static int health = 100;
    public static Point mouseClick = new Point(0,0);
    public static Point mouseLocation = new Point(0,0);
    //public static Image[] towerImages = new Image[1];
    //public String[] tower = new String[]{"none"};
    
    public Window(){
        game.start();
    }
    
    public void paintComponent(Graphics g){
        if(isFirst){
            map = new Map();
            store = new Store();
            enemies = new TheEnemies(map.map[startX][startY], map.map[endX][endY]);
            
            isFirst = false;
        }
        
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        map.draw(g);
        store.draw(g);
        
        enemies.spawn();
        enemies.removeDead();
        enemies.move();
        enemies.removeCompletedPath();
                
        enemies.draw(g);
        
        map.makeTowersShoot(g);
        
        g.setColor(Color.RED);
        g.drawString("\t\tHealth: " + health, 
                map.map[map.map.length-1][0].x + map.tileSize, 
                map.map[map.map.length-1][0].y + map.tileSize);
        
    }
    
    public void run(){
        repaint();
        timerLast = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis() - timerLast >= 1000/fps){  //restricts game to a certain framerate
                repaint();
                timerLast = System.currentTimeMillis();
            }
        }
    }
    
    public static void getHurt(int d){
        health -= d;
    }
}
