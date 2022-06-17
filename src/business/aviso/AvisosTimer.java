package business.aviso;

import java.util.Timer;

import zirks.events.AvisoEvento;

public class AvisosTimer {
	private Timer t;
	
	public AvisosTimer( AvisoEvento a) {
		this.t = new Timer();
		AvisoAssis aa = new AvisoAssis(a);
		t.schedule(aa, a.getPeriodo());
	}
	
	public void endTimer() {
		t.cancel();
	}
	
}
