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
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
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
        for(int j = 0; j < map[0].length; j++){
            for(int i = 0; i < map.length; i++){
                map[i][j].setGroundID(scan.nextInt());
            }
        }
    }
}
