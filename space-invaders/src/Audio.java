import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio implements Runnable {
	Thread t;
	File audioFile;
	AudioInputStream audioStream;
	Clip audioClip;
	String fn;

	public Audio(String fileName, boolean loops) {
		fn = fileName;
		audioFile = new File(fileName);
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);

			if (loops) {
				audioClip.loop(audioClip.LOOP_CONTINUOUSLY);
			}
			audioClip.open(audioStream);
			// audioClip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quit() {
		audioClip.close();
		audioClip.stop();
	}

	public void play() {
		start3();
	}

	public void start3() {
		t = new Thread(this, fn);
		start2();
		t.start();
	}

	public void start() {
		t = new Thread(this, fn);
		t.start();
	}

	public void start2() {
		audioFile = new File(fn);
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		audioClip.start();
	}

}