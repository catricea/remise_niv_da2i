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
    
    public Pacman(Cellule c){
        this.position = c;
        this.dead = false;
    }
    
    public boolean getDead(){
        return this.dead;
    }
    public Cellule getPosition(){
        return this.position;
    }
    
}
