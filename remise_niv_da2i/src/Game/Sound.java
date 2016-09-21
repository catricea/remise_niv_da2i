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

public class Sound {
   private AudioClip clip;
   public Sound(String name){
      try
      {
         clip = Applet.newAudioClip(Display.class.getResource(name));
      }catch (Throwable e){
         e.printStackTrace();
      }
   }
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