/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ppa;

import java.io.File;
import java.util.Scanner;


public class LoadMap {
    
    private String map =
"   1 1 1 1 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 2 3 3 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 2 0 0 0 0 1 1 1 2 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 2 0 0 0 0 4 0 0 2 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 1 1 1 1 1 4 0 0 2 0 1 1 1 1 1 1 1 1    \n" +
"   0 0 0 0 0 0 0 0 0 0 2 0 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 2 0 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 2 0 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 2 3 3 3 3 3 0 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 2 0 0 0 0 0 0 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 2 0 0 0 0 0 0 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 1 1 1 1 1 1 1 4 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    \n" +
"   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0    ";
    
    public static void load(Tile[][] map){
        LoadMap m = new LoadMap();
        Scanner scan = new Scanner(m.map + m.map);
        for(int y = 0; y < map[0].length; y++){
            for(int x = 0; x < map.length; x++){
                map[x][y].setGroundID((scan.nextInt() > 0)? 1: 0);
            }
        }
        for(int y = 0; y < map[0].length; y++){
            for(int x = 0; x < map.length; x++){
                map[x][y].walkDirection = scan.nextInt();
            }
        }
    }
}
