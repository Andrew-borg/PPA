/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.event.*;
import java.awt.*;

public class Mouse implements MouseMotionListener, MouseListener{

    public void mouseDragged(MouseEvent e) {
        
    }

    public void mouseMoved(MouseEvent e) {
        Window.mouseLocation = e.getPoint();
        Window.mouseLocation.translate(0, -20);
    }

    public void mouseClicked(MouseEvent e) {
        Window.mouseClick = e.getPoint();
        Window.mouseClick.translate(0, -20);
        
        Window.map.placeTower();
        Window.store.toggleSelectItem();
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
    
}
