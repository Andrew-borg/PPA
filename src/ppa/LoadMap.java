/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ppa;

import java.io.File;
import java.util.Scanner;


public class LoadMap {
    private static String map =
"   1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    ";
    
     static Scanner scan = new Scanner(map);
    
    public static void load(Tile[][] map){
        for(int y = 0; y < map[0].length; y++){
            for(int x = 0; x < map.length; x++){
                map[x][y].setGroundID(scan.nextInt());
            }
        }
    }
}
