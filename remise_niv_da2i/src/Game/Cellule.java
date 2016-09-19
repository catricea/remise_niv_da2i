/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author catricea
 */
class Cellule {
    
    private int x,y;
    private boolean wall;
    private boolean passed;
    
    public Cellule(int x, int y, boolean wall){
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.passed = false;
    }
    
    public boolean getWall(){
        return this.wall;
    }
    public boolean getPassed(){
        return this.passed;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setPassed(boolean passed){
        this.passed = passed;
    }
    
}
