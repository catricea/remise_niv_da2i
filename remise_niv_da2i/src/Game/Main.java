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
    public static void main(String[] args) throws InterruptedException {
        Display d = new Display(41, 21, -1, 11);
        while(true){
            
            d.refresh();
            //mode texte
            //d.displayMap();
            //mode graphique
            d.repaint();
            Thread.sleep(250);
            d.setVisible(true);
        }
    }
    
}