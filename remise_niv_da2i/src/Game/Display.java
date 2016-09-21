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
import javax.swing.JLabel;

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
        //test
        /*this.ghost1.setWeak(true);
        this.ghost2.setWeak(true);
        this.ghost3.setWeak(true);
        this.ghost4.setWeak(true);*/
        
        
        this.getMap().initialization();
        this.addKeyListener(this);
        
        //Frame
        this.setTitle("PacMan");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**
     * 
     * @param graphics
     */
    public void paint(Graphics g){
        Color defaultColor = this.getBackground();
        
        //réccupère un tableau de cellule
        Cellule[][] c = this.getMap().getCellules();
        
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
                else if(this.getGhost().getPosition().getX() == j && getGhost().getPosition().getY() == i && !this.getGhost().getWeak()){
                    //if getweak()
                    //setColor
                    g.setColor(new Color(240, 6, 6));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost bleu
                else if(this.getGhost2().getPosition().getX() == j && getGhost2().getPosition().getY() == i && !this.getGhost2().getWeak()){
                    g.setColor(new Color(35, 245, 249));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost orange
                else if(this.getGhost3().getPosition().getX() == j && getGhost3().getPosition().getY() == i && !this.getGhost3().getWeak()){
                    g.setColor(new Color(247, 150, 40));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost rose
                else if(this.getGhost4().getPosition().getX() == j && getGhost4().getPosition().getY() == i && !this.getGhost4().getWeak()){
                    g.setColor(new Color(245, 164, 242));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost rouge en bleu
                else if(this.getGhost().getPosition().getX() == j && getGhost().getPosition().getY() == i && this.getGhost().getWeak()){
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost bleu en bleu
                else if(this.getGhost2().getPosition().getX() == j && getGhost2().getPosition().getY() == i && this.getGhost2().getWeak()){
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost orange en bleu
                else if(this.getGhost3().getPosition().getX() == j && getGhost3().getPosition().getY() == i && this.getGhost3().getWeak()){
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le ghost rose en bleu
                else if(this.getGhost4().getPosition().getX() == j && getGhost4().getPosition().getY() == i && this.getGhost4().getWeak()){
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+5, i*30+35, 20, 20);
                }
                //affiche le chemin où pacman est passé
                else if(c[j][i].getPassed()){
                    g.setColor(defaultColor);
                    g.fillRect(j*30, i*30+30, 30, 30);
                }
                //affiche les vitamines
                else if(1 == j && 3 == i || 39 == j && 3 == i || 1 == j && 18 == i || 39 == j && 18 == i){
                    g.setColor(defaultColor);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+10, i*30+40, 12, 12);
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
                break;
        }
    }
    public void refreshPacman(Pacman p){
        Cellule c = p.getPosition();
        //Si on passe sur une vitamine jamais mangé auparavant et que les fantômes sont dangereux
        if((c.getX()== 1 && c.getY()==3) || (c.getX()== 39 && c.getY()==3) || (c.getX()== 1 && c.getY()==18) || (c.getX()== 39 && c.getY()==18) 
                    && this.ghost1.getCountWeak()==0 && !c.getPassed()){
                this.ghost1.setWeak(true);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);
                this.ghost2.setWeak(true);
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setWeak(true);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setWeak(true);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                }
        //getGhost().setCountWeak(getCountWeak+1);
        //5sec => cpt=30
        if(this.ghost1.getCountWeak()==5){
            this.ghost1.setWeak(true);
            this.ghost1.setCountWeak(0);
            this.ghost2.setWeak(true);
            this.ghost1.setCountWeak(0);
            this.ghost3.setWeak(true);
            this.ghost1.setCountWeak(0);
            this.ghost4.setWeak(true);
            this.ghost1.setCountWeak(0);
        }
        switch(this.getPacman().getOrientation()){
            case RIGHT:
                //si Pacman touche la bordure droite this.getMap().getWidth()-1
                if(c.getX()==this.getMap().getWidth()-1){
                    //Pacman est tp devant l'autre passage
                    p.setPosition(-1, c.getY());
                }
                if(!this.getMap().getCellules()[c.getX()+1][c.getY()].getWall()){
                    p.setPosition(c.getX()+1, c.getY());
                    //pacmman est passé par cette case
                    if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed())
                        this.getPacman().setScore(this.getPacman().getScore() + 1);
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            case LEFT:
                //si Pacman touche la bordure gauche this.getMap().getWidth()-1
                if(c.getX()==0){
                    //Pacman est tp devant l'autre passage
                    p.setPosition(this.getMap().getWidth(), c.getY());
                }
                if(!this.getMap().getCellules()[c.getX()-1][c.getY()].getWall()){
                    p.setPosition(c.getX()-1, c.getY());
                    if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed())
                        this.getPacman().setScore(this.getPacman().getScore() + 1);
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
                
                
            case DOWN:
                if(!this.getMap().getCellules()[c.getX()][c.getY()+1].getWall()){
                    p.setPosition(c.getX(), c.getY()+1);
                    if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed())
                        this.getPacman().setScore(this.getPacman().getScore() + 1);
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            case UP:
                if(!this.getMap().getCellules()[c.getX()][c.getY()-1].getWall()){
                    p.setPosition(c.getX(), c.getY()-1);
                    if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed())
                        this.getPacman().setScore(this.getPacman().getScore() + 1);
                    this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                }
                break;
            
        }
    }
    public void refresh(){
        //Mouvements Pacman
        this.refreshPacman(pacman);
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