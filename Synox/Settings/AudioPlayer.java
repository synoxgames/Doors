package Synox.Settings;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class AudioPlayer {

    public static boolean isPlaying = false;
    public static final int maxPlayers = 4;

    static int players = 0;

    public static void PlaySound(String toPlay) {
        if (players >= maxPlayers) return;
        try {
            URL file = new URL("file:"+System.getProperty("user.dir")+"\\Synox\\Settings\\aud\\"+toPlay);

            AudioInputStream audInput = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audInput);
            clip.setFramePosition(0);
            clip.start();
            isPlaying = true;
            players++;
            clip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                        isPlaying = false;
                        players--;
                    }
                }
            });
        } catch (Exception e) {
            GameInfo.Log("Failure: "+e);
        }
    }


    
}
