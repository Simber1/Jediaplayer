package net.prettyawful.JediaPlayer;

import java.io.File;
import java.util.Scanner;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFileChooser;

public class Player  {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		final JFXPanel fxPanel = new JFXPanel();  //Makes JavaFX not die https://stackoverflow.com/questions/14025718/javafx-toolkit-not-initialized-when-trying-to-play-an-mp3-file-through-mediap/43277386#43277386
        
		String song = songSelect().toString();
		
        try {
        	System.out.println(song.toString());
        }
        catch (NullPointerException exc) {
        	System.out.println(exc);
        	exc.printStackTrace();
        	while(song == null) {
        		song = songSelect().toString();
        	}
        }
        
        Scanner scan = new Scanner(System.in); //Scanner for volume controls
        
        System.out.println("Set volume in %:");
        int volumeIn = scan.nextInt(); //taking next int for volume controls
        
        
        double volume = volumeIn/100;  //changing to 0.xx instead of xx%
        Media hit = new Media(new File(song).toURI().toString());  //Changing song into a form that Media can use
        MediaPlayer mediaPlayer = new MediaPlayer(hit);  //Starting media player with track
        
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();  //Playing media
       
        
        scan.close();
        try {
			Thread.sleep(1000000000);  //Sleeps to stop song from ending straight away
		} catch (InterruptedException e) {
			System.out.println("Sleep was interrupted");
			e.printStackTrace();
		}
        
        

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
