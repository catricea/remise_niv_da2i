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
 * son orientation en fonction de la saisie du joueur,
 * le score du joueur en fonction des points ramassés,
 * le score du joueur en fonction des fantômes tués,
 * le score total en fin de partie,
 * et un booléen qui détermine la fin du jeu.
 */
class Pacman {
    
    private Cellule position;
    private boolean dead;
    private int score;
    private int ghostScore;
    private int scoreFinal;
    private Orientation orientation;
    /**
    *constructeur du pacman avec une position sur le plateau
    * initilisation de son orientation vers le haut et du score à 0
    * @param c 
    */
    public Pacman(Cellule c){
        this.position = c;
        this.dead = false;
        this.score = 0;
        this.ghostScore = 0;
        this.scoreFinal= 0;
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
     * permet de modifier l'état de Pacman de mort ou vif
     * @param a 
     */
    public void setDead(boolean a){
        this.dead=a;
    }
    /**
    * réccupère la position de pacman sur le plateau
    * @return position
    */
    public Cellule getPosition(){
        return this.position;
    }
    /**
    * réccupère le score des petits points mangés
    * @return score
    */
    public int getScore(){
        return this.score;
    }
    /**
     * réccupère le score des fantomes mangés
     * @return ghostScore 
     */
    public int getGhostScore(){
        return this.ghostScore;
    }
    /**
     * réccupère le score final
     * @return scoreFinal
     */
    public int getScoreFinal(){
        return this.score+this.ghostScore;
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
    /**
     * permet de modifier le score des fantômes mangés
     * @param score
     */
    public void setGhostScore(int score){
        this.ghostScore = score;
    }
}
