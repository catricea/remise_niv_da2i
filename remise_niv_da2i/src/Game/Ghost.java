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
 * son orientation,
 * un booléen pour savoir s'il est faible ou non,
 * un compteur qui définit le temps de faiblesse du fantôme
 * et un booléen qui s'il est mort ou non.
 */
class Ghost {
    private Cellule position;
    private boolean dead;
    private Orientation orientation;
    private boolean weak;
    private int countWeak;
    /**
    *constructeur du fantôme avec une position sur le plateau
    * initilisation de son orientation vers le haut
    * @param c 
    */
    public Ghost(Cellule c){
        this.position = c;
        this.dead = false;
        this.orientation = Orientation.UP;
        this.weak = false;
        this.countWeak = 0;
    }
    /**
    * récupère le boolean permettant de savoir si le fantôme est mort ou non
    * @return dead
    */
    public boolean getDead(){
        return this.dead;
    }
    /**
     * récupère le boolean permettant de savoir si le fantôme est sensible à Pacman ou non
     * @return weak
     */
    public boolean getWeak(){
        return this.weak;
    }
    /**
    * récupère la position du fantôme sur le plateau
    * @return position
    */
    public Cellule getPosition(){
        return this.position;
    }
    /**
    * récupère l'orientation du fantôme
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
    /**
    * permet de modifier le booléen 'faiblesse' du fantôme
    * @param a 
    */
    public void setWeak(boolean a){
        this.weak = a;
    }
    /**
    * récupère le compteur 'faiblesse' du fantôme
    * @param a 
    */
    public int getCountWeak(){
        return countWeak;
    }
    /**
    * modifie le compteur 'faiblesse' du fantôme
    * @param a 
    */
    public void setCountWeak(int a){
        this.countWeak = a;
    }
    /**
     * permet de modifier l'état du Ghost de mort ou vif
     * @param a 
     */
    public void setDead(boolean a){
        this.dead=a;
    }
}
