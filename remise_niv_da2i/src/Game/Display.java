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
     * construit un affichage avec un plateau, un pacman et des fantômes
     * @param widthMap, heightMap, XPacman, YPacman
     */
    public Display(int widthMap, int heightMap, int XPacman, int YPacman){
        
        this.map = new Map(widthMap, heightMap);
        this.pacman = new Pacman(new Cellule(XPacman, YPacman, false,false));
        this.ghost1 = new Ghost(new Cellule(21,11,false,false));
        this.ghost2 = new Ghost(new Cellule(19,11,false,false));
        this.ghost3 = new Ghost(new Cellule(19,10,false,false));
        this.ghost4 = new Ghost(new Cellule(21,10,false,false));
        this.getMap().initialization();
        this.addKeyListener(this);
        //Frame
        this.setTitle("PacMan");
        this.setSize(1231,690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**
     * affiche la fenêtre du jeu en mode graphique
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
                else if(c[j][i].getVitamined()){
                    g.setColor(defaultColor);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+10, i*30+40, 12, 12);
                }
                //retire des points aux endroits voulus, comme au milieu
                else if(21 == j & 10 == i || 19 == j && 10 == i || 20 == j && 10 == i || 21 == j & 9 == i || 19 == j && 9 == i || 20 == j && 9 == i
                        || 20==j & 8==i || 18==j & 12==i || 19==j & 12==i || 20==j & 12==i || 21==j & 12==i || 22==j & 12==i){
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
        System.out.println("en bas a gauche vitamine ? : " + this.map.getCellules()[1][18].getVitamined());
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
    
    /**
     * gère les déplacements des fantômes sur le plateau
     * @param g 
     */
    public void refreshGhost(Ghost g){
        
        //Idée de path finding :
        //Cellule cp = this.getPacman().getPosition();
        //Cellule cg = g.getPosition();
        //int x = cg.getX() - cp.getX();
        //int y = cg.getY() - cp.getY();
        //if(x > 0 && x > y)
        //RIGHT
        //if(x < 0 && x > y)
        //LEFT
        //if(y > 0 && y > x)
        //UP
        //if(y < 0 && y > x)
        //DOWN
        
        //Ghost Mouvements
        Cellule c = g.getPosition();
        //Permet aux fantômes de sortir de leur maison et de ne pas y rerentrer
        if(g.getPosition().getX()==20 && g.getPosition().getY()==9 || g.getPosition().getY()==10 && g.getPosition().getX()==20){
            g.setOrientation(Orientation.UP);
        }
        if(g.getPosition().getX()==20 && g.getPosition().getY()==7 && g.getOrientation()== Orientation.UP){
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
        //Lance le compteur
        if(g.getCountWeak()>0)
            g.setCountWeak(g.getCountWeak()+1);
        //Tue le fantôme si il est mangé et fait réapparaitre le fantôme si il est mangé
        if(c.getX()==this.pacman.getPosition().getX() && c.getY()==this.pacman.getPosition().getY() && g.getWeak()){
            this.pacman.setGhostScore(this.pacman.getGhostScore()+100);
            g.setPosition(20,11);
        }
        //5sec => cpt=30
        if(g.getCountWeak()==30){
            g.setWeak(false);
            g.setCountWeak(0);
        }
        //Path finding des ghost basique
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
    
    /**
     * gère les déplacements du pacman sur le plateau
     * @param p 
     */
    public void refreshPacman(Pacman p){
        Cellule c = p.getPosition();
        Sound deplacement = new Sound("sounds/sirene.wav");
        Sound mange = new Sound("sounds/mange.wav");
        Sound mort = new Sound("sounds/mort.wav");
        //Si on passe sur une vitamine jamais mangé auparavant et que les fantômes sont dangereux
        if(this.ghost1.getCountWeak()==0 || this.ghost2.getCountWeak()==0 || this.ghost3.getCountWeak()==0 || this.ghost4.getCountWeak()==0){
            if((!c.getPassed()) && (c.getX()== 1 && c.getY()==3)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                this.map.getCellules()[1][3].setVitamined(false);
                c.setPassed(true);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);  
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                this.ghost1.setWeak(true);
                this.ghost2.setWeak(true);
                this.ghost3.setWeak(true);
                this.ghost4.setWeak(true);
            }
            if((!c.getPassed()) && (c.getX()== 1 && c.getY()==18)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                this.map.getCellules()[1][18].setVitamined(false);
                c.setPassed(true);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);  
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                this.ghost1.setWeak(true);
                this.ghost2.setWeak(true);
                this.ghost3.setWeak(true);
                this.ghost4.setWeak(true);
            }
            if((!c.getPassed()) && (c.getX()== 39 && c.getY()==3)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                c.setPassed(true);
                this.map.getCellules()[39][3].setVitamined(false);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);  
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                this.ghost1.setWeak(true);
                this.ghost2.setWeak(true);
                this.ghost3.setWeak(true);
                this.ghost4.setWeak(true);
            }
            if((!c.getPassed()) && (c.getX()== 39 && c.getY()==18)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                c.setPassed(true);
                this.map.getCellules()[39][18].setVitamined(false);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);  
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                this.ghost1.setWeak(true);
                this.ghost2.setWeak(true);
                this.ghost3.setWeak(true);
                this.ghost4.setWeak(true);
            }
        }
        
        //Mort de Pacman
        if(     ((c.getX()==this.ghost1.getPosition().getX() && c.getY()==this.ghost1.getPosition().getY()) && !this.ghost1.getWeak())||
                ((c.getX()==this.ghost2.getPosition().getX() && c.getY()==this.ghost2.getPosition().getY()) && !this.ghost2.getWeak())||
                ((c.getX()==this.ghost3.getPosition().getX() && c.getY()==this.ghost3.getPosition().getY()) && !this.ghost3.getWeak())||
                ((c.getX()==this.ghost4.getPosition().getX() && c.getY()==this.ghost4.getPosition().getY()) && !this.ghost4.getWeak())){
            //Pacman meurt
            mort.play();
            p.setDead(true);
            
        }
            //Cases sans petits points
            this.getMap().getCellules()[18][12].setPassed(true);
            this.getMap().getCellules()[19][12].setPassed(true);
            this.getMap().getCellules()[20][12].setPassed(true);
            this.getMap().getCellules()[21][12].setPassed(true);
            this.getMap().getCellules()[22][12].setPassed(true);
            this.getMap().getCellules()[19][10].setPassed(true);
            this.getMap().getCellules()[20][10].setPassed(true);
            this.getMap().getCellules()[21][10].setPassed(true);
            this.getMap().getCellules()[19][9].setPassed(true);
            this.getMap().getCellules()[20][9].setPassed(true);
            this.getMap().getCellules()[21][9].setPassed(true);
            switch(this.getPacman().getOrientation()){
                case RIGHT:
                    //si Pacman touche la bordure droite this.getMap().getWidth()-1
                    if(c.getX()==this.getMap().getWidth()-1){
                        //Pacman est tp devant l'autre passage
                        p.setPosition(-1, c.getY());
                    }
                    if(!this.getMap().getCellules()[c.getX()+1][c.getY()].getWall()){
                        p.setPosition(c.getX()+1, c.getY());
                        deplacement.play();
                        //pacman est passé par cette case
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            //Ne compte pas les cases sans petits points
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                            this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                            mange.play();
                        }

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
                        deplacement.play();
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                        this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                        mange.play();
                        }
                    }
                    break;


                case DOWN:
                    if(!this.getMap().getCellules()[c.getX()][c.getY()+1].getWall()){
                        p.setPosition(c.getX(), c.getY()+1);
                        deplacement.play();
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                        this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                        mange.play();
                        }
                    }
                    break;
                case UP:
                    if(!this.getMap().getCellules()[c.getX()][c.getY()-1].getWall()){
                        p.setPosition(c.getX(), c.getY()-1);
                        deplacement.play();
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                        this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                        mange.play();
                        }
                    }
                    break;
                        }
        
    }
    /**
     * modifie les déplacements des objets sur le plateau
     */
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

    /**
     * permet d'enregistrer la saisie utilisateur pour les déplacements du pacman
     * @param e 
     */
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