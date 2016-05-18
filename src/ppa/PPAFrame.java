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
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class PPAFrame extends JFrame{
    public static String user = "";
    private static String title = "Trump Tower Defense - Andrew Borg and Shubit Kumar";
    public static Dimension size = new Dimension(800, 600);
    
    public static void main(String[] args) {
        user = JOptionPane.showInputDialog("Computer name");
        PPAFrame frame = new PPAFrame();
        BufferedImage img = null;
    }
    
    public void init(){
        setLayout(new GridLayout(1, 1, 0, 0));
        
        addMouseMotionListener(new Mouse());
        addMouseListener(new Mouse());
        
        Window window = new Window();
        add(window);
        
        setVisible(true);
    }
    
    public PPAFrame(){
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
    }
}
