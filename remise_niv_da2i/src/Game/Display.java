/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
/**
 * @authors Mathieu Huard, Xavier Lamarque, Algerkov Ruskov, Aurélia Catrice
 */

//git sous netbeans :
//ajouter un fichier vers git :
//Team> Add
//Team> Commit
//Team> Pull
//Team> Push
 
public class Display extends JFrame implements KeyListener{
    
    private Map map;
    private Pacman pacman;

    /**
     * construit un affichage avec un plateau et un pacman
     * @param widthMap, heightMap, XPacman, YPacman
     */
    public Display(int widthMap, int heightMap, int XPacman, int YPacman){
        this.map = new Map(widthMap, heightMap);
        this.pacman = new Pacman(new Cellule(XPacman, YPacman, false));
        this.getMap().initialization();
        this.addKeyListener(this);
    }
    
    /**
     * affiche le plateau et Pacman en mode texte
     */
    public void displayMap(){
        Cellule[][] c = this.getMap().getCellules();
        System.out.println(this.getPacman().getOrientation());
        //parcourt le tableau de cellules
        for(int i = 0; i < this.getMap().getHeight(); i++){
            for(int j = 0; j < this.getMap().getWidth(); j++){
            //affiche les murs
            if(c[j][i].getWall())
                System.out.print("*");
            //affiche le pacman
            else if(getPacman().getPosition().getX() == j && getPacman().getPosition().getY() == i)
                System.out.print("C");            
            //affiche le chemin où pacman est passé
            else if(c[j][i].getPassed())
                System.out.print(" ");
            //affiche le chemin
            else
                System.out.print(".");
            }
            System.out.print("\n");
        }
    }
    
    
    public void refresh(){
        Cellule c = this.getPacman().getPosition();
        switch(this.getPacman().getOrientation()){
            case RIGHT:
                if(!this.getMap().getCellules()[c.getX()+1][c.getY()].getWall()){
                    this.getPacman().setPosition(this.getPacman().getPosition().getX()+1, this.getPacman().getPosition().getY());
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            case LEFT:
                if(!this.getMap().getCellules()[c.getX()-1][c.getY()].getWall()){
                    this.getPacman().setPosition(this.getPacman().getPosition().getX()-1, this.getPacman().getPosition().getY());
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            case DOWN:
                if(!this.getMap().getCellules()[c.getX()][c.getY()+1].getWall()){
                    this.getPacman().setPosition(this.getPacman().getPosition().getX(), this.getPacman().getPosition().getY()+1);
                      this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            case UP:
                if(!this.getMap().getCellules()[c.getX()][c.getY()-1].getWall()){
                    this.getPacman().setPosition(this.getPacman().getPosition().getX(), this.getPacman().getPosition().getY()-1);
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            
        }
        displayMap();
    }
    
    public Map getMap(){
        return this.map;
    }
    
    public Pacman getPacman(){
        return this.pacman;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        String touche = KeyEvent.getKeyText( e.getKeyCode() );
        switch (touche){
                case "Gauche":
                    this.getPacman().setOrientation(Orientation.LEFT);
                break;
                case "Droite":
                    this.getPacman().setOrientation(Orientation.RIGHT);
                break;
                case "Haut":
                   this.getPacman().setOrientation(Orientation.UP);
                break;
                case "Bas":
                   this.getPacman().setOrientation(Orientation.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
