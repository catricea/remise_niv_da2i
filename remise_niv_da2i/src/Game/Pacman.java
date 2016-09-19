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
    /**
    *constructeur du pacman avec une position
    * @param c 
    */
    public Pacman(Cellule c){
        this.position = c;
        this.dead = false;
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
    
}
