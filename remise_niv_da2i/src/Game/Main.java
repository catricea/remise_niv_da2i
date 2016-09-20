/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;


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
 
public class Main {
    
/**
 * @param args
 */
    public static void main(String[] args){
         
       Thread thread = new Thread(new Runnable(){
            public void run(){
                Display d = new Display(41, 21, 20, 12);
               
                    while(true){
                        d.setVisible(true);
                        d.refresh();
                        //mode texte
                        //d.displayMap();
                        //mode graphique
                        d.repaint();
                        try{
                        Thread.sleep(180);
                        }catch(InterruptedException e){
                    e.printStackTrace();
                }
                    
                }
                
            }
                
        });
       thread.start();
    }
}