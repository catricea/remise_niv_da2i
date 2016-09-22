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
//ajouter un fichier vers git
//Team> Add
//Team> Commit
//Team> Pull
//Team> Push
 
public class Map {
    
    private int width, height;
    private Pacman pacman;
    private Cellule[][] cellules;

    /**
     * constructeur du plateau de jeu avec une largeur et une hauteur
     * @param width, height
     */
    public Map(int width, int height) {
        this.cellules = new Cellule[width][height];
        this.width = width;
        this.height = height;
    }
    /**
     * initialise le plateau avec des murs aléatoirement
     */
    public void initialization(){
        
        
        int[][] example = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
                          {1,2,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,2,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
                          {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
                          {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1},
                          {1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
                          {1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,1},
                          {1,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,1},
                          {1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1},
                          {1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1},
                          {1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        
        
        for(int i = 0; i < this.getWidth(); i++){
            for(int j = 0; j < this.getHeight(); j++){
                switch(example[j][i]){
                    case 0:
                        this.getCellules()[i][j] = new Cellule(i, j, false,false);
                    break;
                    case 1:
                        this.getCellules()[i][j] = new Cellule(i, j, true,false);
                    break;
                    case 2:
                        this.getCellules()[i][j] = new Cellule(i, j, false,true);
                    break;
                }
            }
        }
        
    }
    
    /**
     * récupère le tableau de cellules du plateau
     * @return celulles
     */
    public Cellule[][] getCellules(){
        return this.cellules;
    }
    /**
     * récupère la largeur du plateau
     * @return width
     */
    public int getWidth(){
        return this.width;
    }
    /**
     * récupère la hauteur du plateau
     * @return height
     */
    public int getHeight(){
        return this.height;
    }
    
}
