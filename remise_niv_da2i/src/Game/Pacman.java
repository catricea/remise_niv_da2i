/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 *
 * @author catricea
 * elle définit l'objet Pacamn
 * elle contient une cellule pour sa position sur le plateau, 
 * son orientation en fonction de la saisie du joueur 
 * et un booléen qui détermine la fin du jeu.
 */
class Pacman {
    
    private Cellule position;
    private boolean dead;
    private int score;
    private Orientation orientation;
    /**
    *constructeur du pacman avec une position sur le plateau et initilisation de son orientation vers le haut
    * @param c 
    */
    public Pacman(Cellule c){
        this.position = c;
        this.dead = false;
        this.score = 0;
        this.orientation = Orientation.UP;
    }
    /**
    * réccupère le booléen permettant de savoir si pacman est mort ou non
    * @return dead
    */
    public boolean getDead(){
        return this.dead;
    }
    /**
    * réccupère la position de pacman sur le plateau
    * @return position
    */
    public Cellule getPosition(){
        return this.position;
    }
    /**
    * réccupère le score du joueur
    * @return score
    */
    public int getScore(){
        return this.score;
    }
    /**
    * réccupère l'orientation de pacman
    * @return orientation
    */
    public Orientation getOrientation(){
        return this.orientation;
    }
    /**
    * permet de modifier la position de pacman
    * @param x
    * @param y 
    */
    public void setPosition(int x, int y){
        this.position.setX(x);
        this.position.setY(y);
    }
    /**
     * permet de modifier l'orientation de pacman
     * @param orientation 
     */
    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
    /**
     * permet de modifier le score du joueur
     * @param score
     */
    public void setScore(int score){
        this.score = score;
    }
    
}
