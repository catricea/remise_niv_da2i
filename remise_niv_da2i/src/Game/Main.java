/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import javax.swing.JOptionPane;


/**
 * @authors Mathieu Huard, Xavier Lamarque, Algerkov Ruskov, Aurélia Catrice 
*/


//git sous netbeans :
//ajouter un fichier vers git :
//Team> Add
//Team> Commit
//Team> Pull
//Team> Push
//modifer un fichier vers git :
//jsute pas de add

//git sous terminal :
//ajouter un fichier vers git :
//git add chemin_fichier
//git commit -am 'nom_comit'
//git pull
//git push


//modifer un fichier vers git :
//juste pas de add
 
/**
 * classe principale pour le lancement du jeu
 * @author catricea
 */
public class Main {
    
/**
 * @param args
 */
    public static void main(String[] args){
         
       Thread thread = new Thread(new Runnable(){
            public void run(){
                Display d = new Display(41, 21, 20, 12);
                //Sound debut = new Sound("sounds/pacman_beginning.wav");
                //debut.play();
                
                while(!d.getPacman().getDead() && d.getPacman().getScore() < 334){
                    d.setVisible(true);
                    d.refresh();
                    //mode texte
                    //d.displayMap();
                    //mode graphique
                    d.repaint();
                    try{
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if(d.getPacman().getScore() == 334)
                    JOptionPane.showMessageDialog(d, "WIN\n Score : \n " + d.getPacman().getScoreFinal());
                else{
                    JOptionPane.showMessageDialog(d, "GAME OVER :( \n Score : \n "+ d.getPacman().getScore());
                }   
            }
                
        });
       thread.start();
    }
}