/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

/**
 * @authors Mathieu Huard, Xavier Lamarque, Algerkov Ruskov, Aurélia Catrice
 */

//git sous netbeans :
//ajouter un fichier vers git :
//Team> Add
//Team> Commit
//Team> Pull
//Team> Push
 
public class Display {
    
    private Map map;

    /**
     * affiche le plateau du jeu en mode texte
     * @param args width, height
     */
    public void displayMap(int w, int h) {
        this.map = new Map(w, h);
        Cellule[][] c = map.getCellules();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
             if(c[j][i].getWall())
                System.out.print("*");
            else
                System.out.print(".");
            }
            System.out.print("\n");
        }
    }
    
}
