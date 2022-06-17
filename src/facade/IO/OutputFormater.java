package facade.IO;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import i18n.I18N;
import static i18n.Messages.*;


public class OutputFormater {

	
	private static Voice voice;
	
	public OutputFormater() {
		voice = VoiceManager.getInstance().getVoice("kevin");
		if (voice != null) {
            voice.allocate();//Allocating Voice
        }
        try {
            voice.setRate(150);//Setting the rate of the voice
            voice.setPitch(100);//Setting the Pitch of the voice
            voice.setVolume(3);//Setting the volume of the voice 
           // voice.speak("I have come here to chew bubble gum and kick ass...and I'm all out of bubble gum.");//Calling speak() method
   
        }catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public static void sendSMS(String nome, int numero, String msg) {
		System.out.println(I18N.getString(SMS_SENT)+": "+msg + " " +
				I18N.getString(SMS_TO)+": " + nome + ": " + numero);
		
	}
	
	public static void voiceSMS(String nome, int numero, String msg) {
		
		String s = I18N.getString(SMS_SENT)+": "+msg + " " +
				I18N.getString(SMS_TO)+": " + nome + ": " + numero;
		System.out.println(s);
		voice.speak(s);
	}
	
	public static void voiceOutPut(String s) {
		System.out.println(s);
		voice.speak(s);
	}
	
	

}
