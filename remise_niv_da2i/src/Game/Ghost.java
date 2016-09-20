/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author lamarqux
 */
class Ghost {
    private Cellule position;
    private boolean dead;
    private Orientation orientation;
    /**
    *constructeur du ghost avec une position
    * @param c 
    */
    public Ghost(Cellule c){
        this.position = c;
        this.dead = false;
        this.orientation = Orientation.UP;
    }
    /**
    * réccupère le boolean permettant de savoir si ghost est mort ou non
    * @return dead
    */
    public boolean getDead(){
        return this.dead;
    }
    /**
    * réccupère la position de ghost
    * @return position
    */
    public Cellule getPosition(){
        return this.position;
    }
    /**
    * réccupère l'orientation de ghost
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
