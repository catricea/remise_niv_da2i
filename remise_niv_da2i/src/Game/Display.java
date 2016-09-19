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
    private Pacman pacman;

    /**
     * construit un affichage avec un plateau et un pacman
     * @param widthMap, heightMap, XPacman, YPacman
     */
    public Display(int widthMap, int heightMap, int XPacman, int YPacman){
        this.map = new Map(widthMap, heightMap);
        this.pacman = new Pacman(new Cellule(XPacman, YPacman, false));
    }
    
    /**
     * affiche le plateau et Pacman en mode texte
     */
    public void displayMap(){
        this.getMap().initialization();

        Cellule[][] c = this.getMap().getCellules();
        for(int i = 0; i < this.getMap().getHeight(); i++){
            for(int j = 0; j < this.getMap().getWidth(); j++){
            if(c[j][i].getWall())
                System.out.print("*");
            else if(getPacman().getPosition().getX() == j && getPacman().getPosition().getY() == i)
                System.out.print("C");
            else
                System.out.print(".");
            }
            System.out.print("\n");
        }
    }
    
    
    public void refresh(){
    }
    
    public Map getMap(){
        return this.map;
    }
    
    public Pacman getPacman(){
        return this.pacman;
    }
    
}
