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
class Pacman {
    
    private Cellule position;
    private boolean dead;
    private Orientation orientation;
    /**
    *constructeur du pacman avec une position
    * @param c 
    */
    public Pacman(Cellule c){
        this.position = c;
        this.dead = false;
        this.orientation = Orientation.RIGHT;
    }
    /**
    * réccupère le boolean permettant de savoir si pacman est mort ou non
    * @return dead
    */
    public boolean getDead(){
        return this.dead;
    }
    /**
    * réccupère la position de pacman
    * @return position
    */
    public Cellule getPosition(){
        return this.position;
    }
    /**
    * réccupère l'orientation de pacman
    * @return position
    */
    public Orientation getOrientation(){
        return this.orientation;
    }
    public void setPosition(int x, int y){
        this.position.setX(x);
        this.position.setY(y);
    }
    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
    
}
