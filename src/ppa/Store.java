/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;

/**
 *
 * @author Christopher
 */
public class Store {
    private int itemsInShop = 3;
    private int buttonSize = 32;
    private int buttonGap = 4;
    private int gapToMap = 40;
    private boolean hasItem = false;
    private int itemHeld;
    private int gold = 1000;
    private Rectangle[] buttons = new Rectangle[itemsInShop];
    private int[] costs = new int[] {10, 0, 0};
    private Color[] towerColors = new Color[]
    {   new Color(200, 20, 20), 
        new Color(200, 20, 20), 
        new Color(200, 20, 20)};
    
    public Store() {
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new Rectangle((i+2)*buttonSize + (buttonGap * i), Map.getMap()[Map.mapWidth-1][Map.mapHeight-1].y + gapToMap, buttonSize, buttonSize);
        }
    }
    
    public void draw(Graphics g){
        for(int i = 0; i < buttons.length; i++){//show shop bar
            if(buttons[i].contains(Window.mouseLocation)){
                g.setColor(new Color(190, 255, 190));
            }else{
                g.setColor(new Color(190, 190, 190));
            }
            g.fillRect(buttons[i].x, buttons[i].y, buttonSize, buttonSize);
        }
        
        for(int i = 0; i < buttons.length; i++){//show shop bar icons
            g.setColor(towerColors[i]);
            g.fillOval(buttons[i].x+buttons[i].width/2-10, buttons[i].y+buttons[i].height/2-10, 20, 20);
        }
        
        if(hasItem){//show held item
            if(itemHeld == 0){
                g.setColor(towerColors[itemHeld]);
                g.fillOval(Window.mouseLocation.x, Window.mouseLocation.y, 20, 20);
            }
        }
        
        g.setColor(Color.YELLOW);
        g.drawString("\t\tGold: " + gold, 
                Window.map.map[Window.map.map.length-1][1].x + Window.map.tileSize, 
                Window.map.map[Window.map.map.length-1][1].y + Window.map.tileSize);
    }
    
    public void toggleSelectItem(){
        hasItem = false;
        
        
        for(int i = 0; i < buttons.length; i++){
            if(buttons[i].contains(Window.mouseClick)){
                hasItem = true;
                itemHeld = i;
            }
        }
    }
    
    public int getItemHeld(){
        return itemHeld;
    }
    
    public int getGold(){
        return gold;
    }
    
    public void spendGold(int amt){
        gold -= amt;
    }
    
    public int getCost(int item){
        return costs[item];
    }
    
    public boolean holdingItem(){
        return hasItem;
    }
}
