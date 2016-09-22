/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 * détermine un type cellule pour l'ensemble du plateau 
 * contient des coordonnées x et y
 * un booléen permettant de savoir s'il s'agit d'un mur
 * n booléen permettant de savoir si pacman est déjà passé dessus
 * @author catricea
 */
class Cellule {
    
    private int x,y;
    private boolean wall;
    private boolean passed;
    private boolean vitamined;
    
    /**
    *constructeur d'une cellule avec des coordonnées et un booléen pour le mur, initilisation du booléen passed à faux
    * @param c 
    */
    public Cellule(int x, int y, boolean wall,boolean vitamined){
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.passed = false;
        this.vitamined = vitamined;
    }
    /**
     * réccupère le booléen permettant de savoir s'il s'agit d'un mur
     * @return wall
     */
    public boolean getWall(){
        return this.wall;
    }
    /**
     * réccupère le booléen permettant de savoir si pacman est déjà passé
     * @return passed
     */
    public boolean getPassed(){
        return this.passed;
    }
    /**
     * réccuère la coordonnée x de la cellule
     * @return x
     */
    public int getX(){
        return this.x;
    }
    /**
     * réccuère la coordonnée y de la cellule
     * @return y
     */
    public int getY(){
        return this.y;
    }
    /**
    * permet de modifier la coordonnée x de la cellule
    * @param x
    */
    public void setX(int x){
        this.x = x;
    }
    /**
    * permet de modifier la coordonnée y de la cellule
    * @param y 
    */
    public void setY(int y){
        this.y = y;
    }
    /**
     * permet de modifier le booléen passed
     * @param passed 
     */
    public void setPassed(boolean passed){
        this.passed = passed;
    }
    /**
     * Récupérer l'info de la case si il y a une vitamine ou pas
     * @return 
     */
    public boolean getVitamined(){
        return vitamined;
    }
    /**
     * La case est marquée comme possédant une vitamine ou non
     * @param vit 
     */
    public void setVitamined(boolean vit){
        this.vitamined=vit;
    }
    
}
