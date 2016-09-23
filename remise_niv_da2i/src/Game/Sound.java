/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Admin
 */
import java.applet.Applet;
import java.applet.AudioClip;

// classe permettant de diffuser du son


public class Sound {
   private AudioClip clip;
   
   // on lui passe l'emplacement du fichier à lire en argument
   public Sound(String name){
      try
      {
         clip = Applet.newAudioClip(Display.class.getResource(name));
      }catch (Throwable e){
         e.printStackTrace();
      }
   }
   
   // méthode permettant de lire un son
   public void play(){
      try{
         new Thread(){
            public void run(){
               clip.play();
            }
         }.start();
      }catch(Throwable e){
         e.printStackTrace();
      }
   }
}