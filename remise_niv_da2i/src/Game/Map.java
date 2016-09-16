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
     * constructeur du plateau de jeu avec une largeur et une hateur
     * @param args width, height
     */
    public Map(int width, int height) {
        this.cellules = new Cellule[width][height];
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){

                if(i == 0 || i == width-1 || j == 0 || j == height-1){
                    if((i == 0 && j == 1) || (i == width-1 && j == height-2))
                        cellules[i][j] = new Cellule(i, j, false);
                    else
                       cellules[i][j] = new Cellule(i, j, true);
                }
                
                else if(i % 2 == 0 && j % 2 == 0)
                        cellules[i][j] = new Cellule(i, j, new Random().nextBoolean());
                else
                cellules[i][j] = new Cellule(i, j, false);             
            }
        }
    }
    
    public Cellule[][] getCellules(){
        return this.cellules;
    }
    public int getWidth(){
        return this.width;
    }
        public int getHeight(){
        return this.height;
    }
    
}
