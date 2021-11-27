package controller;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author Admin
 */
public class Sound {
    private Clip myClip;
    public Sound(String fileName) {
            try {
                this.myClip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("sound/"+fileName));
                myClip.open(ais);
//                File file = new File(fileName);
//                if (file.exists()) {
//                    this.myClip = AudioSystem.getClip();
//                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("sound/backgroundsound.wav"));
//                    myClip.open(ais);
//                }
//                else {
//                    throw new RuntimeException("Sound: file not found: " + fileName);
//                }
            }
            catch (MalformedURLException e) {
                throw new RuntimeException("Sound: Malformed URL: " + e);
            }
            catch (UnsupportedAudioFileException e) {
                throw new RuntimeException("Sound: Unsupported Audio File: " + e);
            }
            catch (IOException e) {
                throw new RuntimeException("Sound: Input/Output Error: " + e);
            }
            catch (LineUnavailableException e) {
                throw new RuntimeException("Sound: Line Unavailable: " + e);
            }
    }
    public void play(){
//        System.out.println("hung");
        myClip.setFramePosition(0);  // Must always rewind!
        myClip.loop(0);
        myClip.start();
    }
    public void loop(){
        myClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        myClip.stop();
    }
    
    public static synchronized void soundClick(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("sound/click.wav"));
                    clip.open(audioInputStream);
                    clip.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    
    public static synchronized void soundVictory(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("sound/winning.wav"));
                    clip.open(audioInputStream);
                    clip.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    
    public static synchronized void soundGameOver(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("sound/gameover.wav"));
                    clip.open(audioInputStream);
                    clip.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    
    public static synchronized void soundBackGround(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("sound/backgroundsound.wav"));
                    clip.open(audioInputStream);
                    clip.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    
}