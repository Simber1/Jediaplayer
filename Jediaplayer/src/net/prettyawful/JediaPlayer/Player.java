package net.prettyawful.JediaPlayer;

import java.io.File;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;

public class Player {


	public static void main(String[] args) {

        
		File song = songSelect();
		System.out.println(song.toString());
//        Media hit = new Media(new song.toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(hit);
//        mediaPlayer.play();
//        Clip clip = new AudioSystem.getClip();
        
//        Thread.sleep(clip.getMicrosecondLength() / 1000);
	}
	
	
	public static File songSelect() {
		final JFileChooser fc = new JFileChooser();  //starting Java File chooser    TO REPLACE
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);  //Setting file chooser to files only
		int returnVal = fc.showOpenDialog(fc);  //Opening file chooser, returns 0 on success and 1 on fail
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File song = fc.getSelectedFile();
			System.out.println("Opening: " + song.getName() + ".");
			return song;
		} else {
			System.out.println("Canceled by user");
			return null;
        }
		
		
	}

}
