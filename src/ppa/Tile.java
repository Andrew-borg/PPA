/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppa;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile extends Rectangle {
    private Enemy target;
    private int shootSpeed = 20;
    private int shootDuration = 10;
    private boolean isShooting = false;
    private int frameCounter = 0;

    public int walkDirection;
    private int groundID;
    private int towerID;
    private Color[] towerColors = new Color[]{new Color(200, 20, 20),
        new Color(20, 200, 20),
        new Color(20, 20, 200)};
    private int[] towerDamage = new int[]
            {10, 10, 10};

    public Tile(int x, int y, int width, int height, int groundID, int airID) {
        setBounds(x, y, width, height);
        this.groundID = groundID;
        this.towerID = airID;
    }

    public void draw(Graphics g) {
        if (groundID == 0) {
            g.setColor(new Color(0, 120, 0));
        }
        if (groundID == 1) {
            g.setColor(new Color(140, 140, 140));
        }
        g.fillRect(x + 1, y + 1, width - 2, height - 2);
        //color the ground

        //color the tower
        if (towerID != 0) {
            //g.setColor(towerColors[towerID-1]);
            //g.fillOval(x+width/2-10, y+height/2-10, 20, 20);
            if (towerID == 1) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("C:\\Users\\" + PPAFrame.studentID + "\\Documents\\NetBeansProjects\\PPA\\src\\ppa\\VerminSupreme.jpg"));
                } catch (IOException e) {
                }
                g.drawImage(img, x + 1, y + 1, null);
            }
            if (towerID == 2) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("C:\\Users\\" + PPAFrame.studentID + "\\Documents\\NetBeansProjects\\PPA\\src\\ppa\\Hillary.png"));
                } catch (IOException e) {
                }
                g.drawImage(img, x + 1, y + 1, null);
            }
            if (towerID == 3) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("C:\\Users\\" + PPAFrame.studentID + "\\Documents\\NetBeansProjects\\PPA\\src\\ppa\\Bernie.jpg"));
                } catch (IOException e) {
                }
                g.drawImage(img, x + 1, y + 1, null);
            }
        }
    }

    public int getGroundID() {
        return groundID;
    }

    public void setGroundID(int id) {
        groundID = id;
    }

    public int getTowerID() {
        return towerID;
    }

    public void setTowerID(int id) {
        towerID = id;
    }
    
    public void shootWithTower(Graphics g){
        if(frameCounter % shootSpeed == 0){
            if(target != null){
                isShooting = true;
            }
        }
        if(isShooting && frameCounter % shootSpeed <= shootDuration){
            Image img = null;
            try {
                img = ImageIO.read(new File("C:\\Users\\" + PPAFrame.studentID + "\\Documents\\NetBeansProjects\\PPA\\src\\ppa\\Fist.jpg"));
            } catch (IOException e) {
            }
            g.drawImage(img, target.x + 3, target.y + 3, null);
        }
    }

}
