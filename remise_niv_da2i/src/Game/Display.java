/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
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
    private Ghost ghost1;
    private Ghost ghost2;
    private Ghost ghost3;
    private Ghost ghost4;
    
    

    /**
     * construit un affichage avec un plateau et un pacman
     * @param widthMap, heightMap, XPacman, YPacman
     */
    public Display(int widthMap, int heightMap, int XPacman, int YPacman){
        
        this.map = new Map(widthMap, heightMap);
        this.pacman = new Pacman(new Cellule(XPacman, YPacman, false));
        this.ghost1 = new Ghost(new Cellule(21,11,false));
        this.ghost2 = new Ghost(new Cellule(19,11,false));
        this.ghost3 = new Ghost(new Cellule(19,10,false));
        this.ghost4 = new Ghost(new Cellule(21,10,false));
        
        this.getMap().initialization();
        this.addKeyListener(this);
        
        //Frame
        this.setSize(widthMap, heightMap);
        this.setTitle("PacMan");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * 
     * @param graphics
     */
    public void paint(Graphics g){
        
        //réccupère un tableau de cellule
        Cellule[][] c = this.getMap().getCellules();
        
        Color defaultColor = this.getBackground();
   
        //parcourt le tableau de cellules
        for(int i = 0; i < this.getMap().getHeight(); i++){
            for(int j = 0; j < this.getMap().getWidth(); j++){

                //affiche les murs
                if(c[j][i].getWall()){
                    g.setColor( new Color(129, 159, 210));
                    g.fillRect(j*30, i*30+30, 30, 30);
                }                
                    
                //affiche le pacman
                else if(getPacman().getPosition().getX() == j && getPacman().getPosition().getY() == i){
                    g.setColor(new Color(255, 224, 119));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost rouge
                else if(this.getGhost().getPosition().getX() == j && getGhost().getPosition().getY() == i){
                    g.setColor(new Color(240, 6, 6));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost bleu
                else if(this.getGhost2().getPosition().getX() == j && getGhost2().getPosition().getY() == i){
                    g.setColor(new Color(35, 245, 249));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost orange
                else if(this.getGhost3().getPosition().getX() == j && getGhost3().getPosition().getY() == i){
                    g.setColor(new Color(247, 150, 40));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost rose
                else if(this.getGhost4().getPosition().getX() == j && getGhost4().getPosition().getY() == i){
                    g.setColor(new Color(245, 164, 242));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le chemin où pacman est passé
                else if(c[j][i].getPassed()){
                    g.setColor(defaultColor);
                    g.fillRect(j*30, i*30+30, 30, 30);
                }
                
                //affiche le chemin
                else{
                    g.setColor(defaultColor);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.setColor(new Color(235, 88, 59));
                    g.fillOval(j*30+10, i*30+40, 10, 10);
                }

            }          
        }
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
            
            //affiche le ghost
             else if(getGhost().getPosition().getX() == j && getGhost().getPosition().getY() == i)
                System.out.print("F");
            
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
    public void refreshGhost(Ghost g){
        //Ghost Mouvements
        Cellule c = g.getPosition();
        switch(g.getOrientation()){
            case RIGHT:
                //si Ghost touche la bordure droite this.getMap().getWidth()-1
                if(c.getX()==this.getMap().getWidth()-1){
                    //Pacman est tp devant l'autre passage
                    g.setPosition(-1, c.getY());
                }
                if(!this.getMap().getCellules()[c.getX()+1][c.getY()].getWall()){
                    
                    g.setPosition(c.getX()+1, c.getY());
                }
                
                else{
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                /*if(!this.getMap().getCellules()[c2.getX()+1][c2.getY()].getWall()){
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            this.getGhost().setOrientation(Orientation.UP);
                            break;
                        case 1:
                            this.getGhost().setOrientation(Orientation.DOWN);
                            break;
                    }
                    
                }*/
                break;
            case LEFT:
                //si Ghost touche la bordure gauche this.getMap().getWidth()-1
                if(c.getX()==0){
                    //Ghost est tp devant l'autre passage
                    g.setPosition(this.getMap().getWidth(), c.getY());
                }
                if(!this.getMap().getCellules()[c.getX()-1][c.getY()].getWall()){
                    g.setPosition(c.getX()-1, c.getY());
                }
                else{
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                /*if(!this.getMap().getCellules()[c2.getX()-1][c2.getY()].getWall()){
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            this.getGhost1().setOrientation(Orientation.UP);
                            break;
                        case 1:
                            this.getGhost1().setOrientation(Orientation.DOWN);
                            break;
                    }
                }*/
                break;
                
                
            case DOWN:
                if(!this.getMap().getCellules()[c.getX()][c.getY()+1].getWall()){
                    g.setPosition(c.getX(), c.getY()+1);
                }
                else{
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                    }
                }
                /*if(!this.getMap().getCellules()[c2.getX()][c2.getY()+1].getWall()){
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            this.getGhost1().setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            this.getGhost1().setOrientation(Orientation.RIGHT);
                            break;
                    }
                }*/
                break;
            case UP:
                if(!this.getMap().getCellules()[c.getX()][c.getY()-1].getWall()){
                    g.setPosition(c.getX(), c.getY()-1);
                }
                else{
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                    }
                }
                /*if(!this.getMap().getCellules()[c2.getX()][c2.getY()-1].getWall()){
                    Random rand = new Random();
                    int nombre = rand.nextInt(2);
                    switch(nombre)
                    {
                        case 0:
                            this.getGhost().setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            this.getGhost().setOrientation(Orientation.RIGHT);
                            break;
                    }
                }*/
                break;
        }
    }
    
    public void refresh(){
        // Pacman mouvements
        Cellule c = this.getPacman().getPosition();
        switch(this.getPacman().getOrientation()){
            case RIGHT:
                //si Pacman touche la bordure droite this.getMap().getWidth()-1
                if(this.getPacman().getPosition().getX()==this.getMap().getWidth()-1){
                    //Pacman est tp devant l'autre passage
                    this.getPacman().setPosition(-1, this.getPacman().getPosition().getY());
                }
                if(!this.getMap().getCellules()[c.getX()+1][c.getY()].getWall()){
                    
                    this.getPacman().setPosition(this.getPacman().getPosition().getX()+1, this.getPacman().getPosition().getY());
                    //pacmman est passé par cette case
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            case LEFT:
                //si Pacman touche la bordure gauche this.getMap().getWidth()-1
                if(this.getPacman().getPosition().getX()==0){
                    //Pacman est tp devant l'autre passage
                    this.getPacman().setPosition(this.getMap().getWidth(), this.getPacman().getPosition().getY());
                }
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
        //Mouvements Ghost
        this.refreshGhost(ghost1);
        this.refreshGhost(ghost2);
        this.refreshGhost(ghost3);
        this.refreshGhost(ghost4);
        displayMap();
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
  
    public Map getMap(){
        return this.map;
    }
    
    public Ghost getGhost(){
        return this.ghost1;
    }
    public Pacman getPacman(){
        return this.pacman;
    }
    public Ghost getGhost2(){
        return this.ghost2;
    }
    public Ghost getGhost3(){
        return this.ghost3;
    }
    public Ghost getGhost4(){
        return this.ghost4;
    }
}
