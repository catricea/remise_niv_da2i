/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    
    private Image IPacmanUp = null;
    private Image IPacmanDown = null;
    private Image IPacmanRight = null;
    private Image IPacmanLeft = null;
    
    private Image IGhost1 = null;
    private Image IGhost2 = null;
    private Image IGhost3 = null;
    private Image IGhost4 = null;
    private Image IGhost5 = null;
    
    private Image IWall = null;

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
            
        
        try {
            IPacmanUp = ImageIO.read(getClass().getResource("pictures/pacmanUp.png"));
            IPacmanDown = ImageIO.read(getClass().getResource("pictures/pacmanDown.png"));
            IPacmanLeft = ImageIO.read(getClass().getResource("pictures/pacmanLeft.png"));
            IPacmanRight = ImageIO.read(getClass().getResource("pictures/pacmanRight.png"));
            
            IGhost1 = ImageIO.read(getClass().getResource("pictures/ghost1.png"));
            IGhost2 = ImageIO.read(getClass().getResource("pictures/ghost2.png"));
            IGhost3 = ImageIO.read(getClass().getResource("pictures/ghost3.png"));
            IGhost4 = ImageIO.read(getClass().getResource("pictures/ghost4.png"));
            IGhost5 = ImageIO.read(getClass().getResource("pictures/ghost5.png"));
            
            IWall = ImageIO.read(getClass().getResource("pictures/wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.getMap().initialization();
        this.addKeyListener(this);
        //Frame
        this.setTitle("PacMan");
        this.setSize(1231,664);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**
     * affiche la fenêtre du jeu en mode graphique
     * @param graphics
     */
    public void paint(Graphics g){
        
       // Graphics2D g2 = (Graphics2D) g;
        
        this.setTitle("Pacman "+ "Score : " + this.pacman.getScoreFinal());
        this.getContentPane().setBackground(Color.black);
        //réccupère un tableau de cellule
        Cellule[][] c = this.getMap().getCellules();
        
        //parcourt le tableau de cellules
        for(int i = 0; i < this.getMap().getHeight(); i++){
            for(int j = 0; j < this.getMap().getWidth(); j++){
                //affiche les murs
                if(c[j][i].getWall()){
                    g.setColor( new Color(11, 4, 200));
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IWall,j*30,i*30+30,this);
                }                 
                //affiche le pacman
                else if(getPacman().getPosition().getX() == j && getPacman().getPosition().getY() == i){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    if(getPacman().getOrientation() == Orientation.UP)
                        g.drawImage(IPacmanUp,j*30+5,i*30+35,this);
                    else if(getPacman().getOrientation() == Orientation.DOWN)
                        g.drawImage(IPacmanDown,j*30+5,i*30+35,this);
                    else if(getPacman().getOrientation() == Orientation.RIGHT)
                        g.drawImage(IPacmanRight,j*30+5,i*30+35,this); 
                    else if(getPacman().getOrientation() == Orientation.LEFT)
                        g.drawImage(IPacmanLeft,j*30+5,i*30+35,this);
                      
                }
                //affiche le ghost rouge
                else if(this.getGhost().getPosition().getX() == j && getGhost().getPosition().getY() == i && !this.getGhost().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost1,j*30+5,i*30+35,this);
                }
                //affiche le ghost bleu
                else if(this.getGhost2().getPosition().getX() == j && getGhost2().getPosition().getY() == i && !this.getGhost2().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost2,j*30+5,i*30+35,this);
                }
                //affiche le ghost orange
                else if(this.getGhost3().getPosition().getX() == j && getGhost3().getPosition().getY() == i && !this.getGhost3().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost3,j*30+5,i*30+35,this);
                }
                //affiche le ghost rose
                else if(this.getGhost4().getPosition().getX() == j && getGhost4().getPosition().getY() == i && !this.getGhost4().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost4,j*30+5,i*30+35,this);
                }
                //affiche le ghost rouge en bleu
                else if(this.getGhost().getPosition().getX() == j && getGhost().getPosition().getY() == i && this.getGhost().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost5,j*30+5,i*30+35,this);
                }
                //affiche le ghost bleu en bleu
                else if(this.getGhost2().getPosition().getX() == j && getGhost2().getPosition().getY() == i && this.getGhost2().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    if(IGhost5 != null)
                        g.drawImage(IGhost5,j*30+5,i*30+35,this);
                }
                //affiche le ghost orange en bleu
                else if(this.getGhost3().getPosition().getX() == j && getGhost3().getPosition().getY() == i && this.getGhost3().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost5,j*30+5,i*30+35,this);
                }
                //affiche le ghost rose en bleu
                else if(this.getGhost4().getPosition().getX() == j && getGhost4().getPosition().getY() == i && this.getGhost4().getWeak()){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.drawImage(IGhost5,j*30+5,i*30+35,this);
                }
                //affiche le chemin où pacman est passé
                else if(c[j][i].getPassed()){
                    g.setColor(Color.black);
                    g.fillRect(j*30, i*30+30, 30, 30);
                }
                //affiche les vitamines
                else if(c[j][i].getVitamined()){
                    g.setColor(Color.black);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.setColor(new Color(6, 38, 225));
                    g.fillOval(j*30+10, i*30+40, 12, 12);
                }
                //retire des points aux endroits voulus, comme au milieu
                else if(21 == j & 10 == i || 19 == j && 10 == i || 20 == j && 10 == i || 21 == j & 9 == i || 19 == j && 9 == i || 20 == j && 9 == i
                        || 20==j & 8==i || 18==j & 12==i || 19==j & 12==i || 20==j & 12==i || 21==j & 12==i || 22==j & 12==i){
                    g.setColor(Color.black);
                    g.fillRect(j*30, i*30+30, 30, 30);
                }
                //affiche le chemin
                else{
                    g.setColor(Color.black);
                    g.fillRect(j*30, i*30+30, 30, 30);
                    g.setColor(new Color(235, 88, 59));
                    g.fillOval(j*30+10, i*30+40, 5, 5);
                }
            }          
        }
    }
    
    /**
     * affiche le plateau et Pacman en mode texte
     */
    public void displayMap(){
        
        Cellule[][] c = this.getMap().getCellules();
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
        if(g.getCountWeak()==60){
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
        //Path finding des ghosts intersections pour qu'ils aillent partout
        switch(g.getPosition().getY()){
            case 1:
                if(g.getPosition().getX()==10){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                if(g.getPosition().getX()==30){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                break;
            case 4:
                if(g.getPosition().getX()==1){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                if(g.getPosition().getX()==10){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(4);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 3:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==17){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                if(g.getPosition().getX()==19){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==21){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==23){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                if(g.getPosition().getX()==30){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(4);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 3:
                            g.setOrientation(Orientation.UP);
                    }
                }
                if(g.getPosition().getX()==39){
                    
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                break;
            case 8:
                if(g.getPosition().getX()==10){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==19){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==21){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==30){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                break;
            case 11:
                if(g.getPosition().getX()==10){
                    Random rand = new Random();
                    int nombre = rand.nextInt(4);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 3:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==17){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==23){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
                if(g.getPosition().getX()==30){
                    Random rand = new Random();
                    int nombre = rand.nextInt(4);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 3:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                break;
            case 12:
                if(g.getPosition().getX()==17){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
            if(g.getPosition().getX()==23){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
            case 13:
                if(g.getPosition().getX()==10){
                    Random rand = new Random();
                    int nombre = rand.nextInt(4);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 3:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
            if(g.getPosition().getX()==17){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
            if(g.getPosition().getX()==23){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
            if(g.getPosition().getX()==30){
                    Random rand = new Random();
                    int nombre = rand.nextInt(4);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 3:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
            case 15:
                if(g.getPosition().getX()==10){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.DOWN);
                            break;
                        case 2:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                    }
                }
                if(g.getPosition().getX()==19){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                    }
                }
                if(g.getPosition().getX()==21){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                    }
                }
                if(g.getPosition().getX()==30){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.UP);
                            break;
                        case 1:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.DOWN);
                            break;
                    }
                }
            case 16:
                if(g.getPosition().getX()==7){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
                if(g.getPosition().getX()==33){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
            case 18:
                if(g.getPosition().getX()==19){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
            if(g.getPosition().getX()==21){
                    Random rand = new Random();
                    int nombre = rand.nextInt(3);
                    switch(nombre)
                    {
                        case 0:
                            g.setOrientation(Orientation.LEFT);
                            break;
                        case 1:
                            g.setOrientation(Orientation.RIGHT);
                            break;
                        case 2:
                            g.setOrientation(Orientation.UP);
                            break;
                    }
                }
        }
    }
    /**
     * gère les collisions lors des raffraîchissements entre pacman et un fantôme
     * @param pacman
     * @param ghost
     * @return boolean
     */
    public boolean collision(Pacman pacman, Ghost ghost){
        if(pacman.getPosition().getX() == ghost.getPosition().getX() && pacman.getPosition().getY() == ghost.getPosition().getY())
            return true;
        else if(pacman.getPosition().getX() == ghost.getPosition().getX()-1 && pacman.getPosition().getY() == ghost.getPosition().getY() &&
                ghost.getOrientation() == Orientation.LEFT && pacman.getOrientation() == Orientation.RIGHT)
            return true;
        else if(pacman.getPosition().getX()-1 == ghost.getPosition().getX() && pacman.getPosition().getY() == ghost.getPosition().getY() &&
                ghost.getOrientation() == Orientation.RIGHT && pacman.getOrientation() == Orientation.LEFT)
            return true;
        else if(pacman.getPosition().getX() == ghost.getPosition().getX() && pacman.getPosition().getY()-1 == ghost.getPosition().getY() &&
                ghost.getOrientation() == Orientation.DOWN && pacman.getOrientation() == Orientation.UP)
            return true;
        else if(pacman.getPosition().getX()-1 == ghost.getPosition().getY()-1 && pacman.getPosition().getY() == ghost.getPosition().getY() &&
                ghost.getOrientation() == Orientation.UP && pacman.getOrientation() == Orientation.DOWN)
            return true;
        else
            return false;
    }
    
    
    /**
     * gère les déplacements du pacman sur le plateau
     * @param p 
     */
    public void refreshPacman(Pacman p){
        Cellule c = p.getPosition();
        //Sound deplacement = new Sound("sounds/sirene.wav");
        //Sound mange = new Sound("sounds/mange.wav");
        //Sound mort = new Sound("sounds/mort.wav");
        //Si on passe sur une vitamine jamais mangé auparavant et que les fantômes sont dangereux
        if(this.ghost1.getCountWeak()==0 || this.ghost2.getCountWeak()==0 || this.ghost3.getCountWeak()==0 || this.ghost4.getCountWeak()==0){
            //Si Pacman n'est pas passé sur cette cellule
            if((this.map.getCellules()[1][3].getPassed()) && this.map.getCellules()[1][3].getVitamined() && (c.getX()== 1 && c.getY()==3)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                this.map.getCellules()[1][3].setVitamined(false);
                this.map.getCellules()[1][3].setPassed(true);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);  
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                this.ghost1.setWeak(true);
                this.ghost2.setWeak(true);
                this.ghost3.setWeak(true);
                this.ghost4.setWeak(true);
            }
            if((this.map.getCellules()[1][18].getPassed()) && this.map.getCellules()[1][18].getVitamined() && (c.getX()== 1 && c.getY()==18)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                this.map.getCellules()[1][18].setVitamined(false);
                this.map.getCellules()[1][18].setPassed(true);
                this.ghost1.setCountWeak(this.ghost1.getCountWeak()+1);  
                this.ghost2.setCountWeak(this.ghost2.getCountWeak()+1);
                this.ghost3.setCountWeak(this.ghost3.getCountWeak()+1);
                this.ghost4.setCountWeak(this.ghost4.getCountWeak()+1);
                this.ghost1.setWeak(true);
                this.ghost2.setWeak(true);
                this.ghost3.setWeak(true);
                this.ghost4.setWeak(true);
            }
            if((this.map.getCellules()[39][3].getPassed()) && this.map.getCellules()[39][3].getVitamined() && (c.getX()== 39 && c.getY()==3)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                this.map.getCellules()[39][3].setPassed(true);
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
            if((this.map.getCellules()[39][18].getPassed()) && this.map.getCellules()[39][18].getVitamined() && (c.getX()== 39 && c.getY()==18)){
                //La position de la vitamine ne pourra plus donner des forces à Pacman
                this.map.getCellules()[39][18].setPassed(true);
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
        if(     (this.collision(pacman, ghost1) && !this.ghost1.getWeak())||
                (this.collision(pacman, ghost2) && !this.ghost2.getWeak())||
                (this.collision(pacman, ghost3) && !this.ghost3.getWeak())||
                (this.collision(pacman, ghost4) && !this.ghost4.getWeak())){
            //Pacman meurt
            //mort.play();
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
                        //deplacement.play();
                        //pacman est passé par cette case
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            //Ne compte pas les cases sans petits points
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                            this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                            //mange.play();
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
                        //deplacement.play();
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                        this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                        //mange.play();
                        }
                    }
                    break;


                case DOWN:
                    if(!this.getMap().getCellules()[c.getX()][c.getY()+1].getWall()){
                        p.setPosition(c.getX(), c.getY()+1);
                        //deplacement.play();
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                        this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                        //mange.play();
                        }
                    }
                    break;
                case UP:
                    if(!this.getMap().getCellules()[c.getX()][c.getY()-1].getWall()){
                        p.setPosition(c.getX(), c.getY()-1);
                        //deplacement.play();
                        if(!this.getMap().getCellules()[c.getX()][c.getY()].getPassed()){
                            this.getPacman().setScore(this.getPacman().getScore() + 1);
                        this.getMap().getCellules()[c.getX()][c.getY()].setPassed(true);
                        //mange.play();
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