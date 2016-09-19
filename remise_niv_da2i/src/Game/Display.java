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
    
    public Display(int w, int h){
        this.map = new Map(w, h);
        System.out.println(this.getMap().getHeight());
    }
    
    public void displayMap(){
        this.getMap().initialization();
        System.out.println(this.getMap().getHeight());
        Cellule[][] c = this.getMap().getCellules();
        for(int i = 0; i < this.getMap().getHeight(); i++){
            for(int j = 0; j < this.getMap().getWidth(); j++){
             if(c[j][i].getWall())
                System.out.print("*");
            else
                System.out.print(".");
            }
            System.out.print("\n");
        }
    }
    
    public Map getMap(){
        return this.map;
    }
    
}
