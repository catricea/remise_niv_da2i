/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.util.Random;

/**
 * @authors Mathieu Huard, Xavier Lamarque, Algerkov Ruskov, Aurélia Catrice
 */

//git sous netbeans :
//ajouter un fichier vers git :
//Team> Add
//Team> Commit
//Team> Pull
//Team> Push
 
public class Map {
    
    private int width, height;
    private Cellule[][] cellules;

    /**
     * constructeur du plateau de jeu avec une largeur et une hauteur
     * @param args width, height
     */
    public Map(int width, int height) {
        this.cellules = new Cellule[width][height];
        this.width = width;
        this.height = height;
    }
    /**
     * initialise le plateau en mode texte avec des murs aléatoirement
     */
    public void initialization(){
        for(int i = 0; i < this.getWidth(); i++){
            for(int j = 0; j < this.getHeight(); j++){

                if(i == 0 || i == this.getWidth()-1 || j == 0 || j == this.getHeight()-1){
                    if((i == 0 && j == 1) || (i == this.getWidth()-1 && j == this.getHeight()-2))
                        this.getCellules()[i][j] = new Cellule(i, j, false);
                    else
                       this.getCellules()[i][j] = new Cellule(i, j, true);
                }
                
                else if(i % 2 == 0 && j % 2 == 0)
                        this.getCellules()[i][j] = new Cellule(i, j, new Random().nextBoolean());
                else
                this.getCellules()[i][j] = new Cellule(i, j, false);             
            }
        }
    }
    
    /**
     * réccupère le tableau de cellules du plateau
     * @return celulles
     */
    public Cellule[][] getCellules(){
        return this.cellules;
    }
    /**
     * réccupère la largeur du plateau
     * @return width
     */
    public int getWidth(){
        return this.width;
    }
    /**
     * réccupère la hauteur du plateau
     * @return height
     */
    public int getHeight(){
        return this.height;
    }
    
}
