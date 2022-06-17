package business.aviso;


import java.util.TimerTask;

import zirks.events.AvisoEvento;

public class AvisoAssis extends TimerTask {
	private AvisoEvento w;
	
	public AvisoAssis(AvisoEvento w) {
		this.w = w;
	}

	@Override
	public void run() {
		System.err.println(w.toString());
	}

}
