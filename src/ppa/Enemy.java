package ppa;

public class Enemy {
    private Tile[][] grid;
    private int temp=1;
    /*1 = Left
    2 = Right
    3 = Up
    4 = Down*/
    private int r,c, health, speed;
    
    public Enemy(Tile[][] grid, int x, int y){
        this.grid = grid;
        r = x;
        c = y;
    }
    
    public Tile getDirection(){
        if(r>0 && grid[r-1][c].getGroundID()==0 && temp != 2){
            temp = 1;
            r--;
            return grid[r][c];
        }
        if(r<grid.length && grid[r+1][c].getGroundID()==0 && temp != 1){
            temp = 2;
            r++;
            return grid[r][c];
        }
        if(c>0 && grid[r][c-1].getGroundID()==0 && temp != 4){
            temp = 3;
            c--;
            return grid[r][c];
        }
        if(c<grid[r].length && grid[r][c+1].getGroundID()==0 && temp != 3){
            temp = 4;
            c++;
            return grid[r][c];
        }
        return null;
    }
    
    public Tile getPosition(){
        return grid[r][c];
    }
}
