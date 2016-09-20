/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 * @author lamarqux
 * elle définit l'objet Fantôme
 * elle contient une cellule pour sa position sur le plateau, 
 * son orientation aléatoire
 * et un booléen qui s'il est mort ou non.
 */
class Ghost {
    private Cellule position;
    private boolean dead;
    private Orientation orientation;
    /**
    *constructeur du fantôme avec une position sur le plateau et initilisation de son orientation vers le haut
    * @param c 
    */
    public Ghost(Cellule c){
        this.position = c;
        this.dead = false;
        this.orientation = Orientation.UP;
    }
    /**
    * réccupère le boolean permettant de savoir si le fantôme est mort ou non
    * @return dead
    */
    public boolean getDead(){
        return this.dead;
    }
    /**
    * réccupère la position du fantôme sur le plateau
    * @return position
    */
    public Cellule getPosition(){
        return this.position;
    }
    /**
    * réccupère l'orientation du fantôme
    * @return orientation
    */
    public Orientation getOrientation(){
        return this.orientation;
    }
    /**
    * permet de modifier la position du fantôme
    * @param x
    * @param y 
    */
    public void setPosition(int x, int y){
        this.position.setX(x);
        this.position.setY(y);
    }
    /**
    * permet de modifier l'orientation du fantôme
    * @param orientation 
    */
    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
}
