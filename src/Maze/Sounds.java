/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maze;
import java.io.File;
import javax.sound.sampled.*;
/**
 *
 * @author MoHamedTemo
 */
public class Sounds {
       static Sounds pl =new Sounds();
       static Sounds pl2 =new Sounds();
        static Clip clip;

        private Sounds()
        {

        }

        public static Sounds getInstance(){
        return pl;
        }
        
        public static Sounds getInstance2(){
        return pl2;
        }

     public static void playMusic(String location) {

        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                 clip = AudioSystem.getClip();
                clip.open(audioInput);
            } else {
                System.out.println("Cant find file");
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

        
}
