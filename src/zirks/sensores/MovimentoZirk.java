package zirks.sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import i18n.I18N;
import zirks.events.MovimentoEvento;

import static i18n.Messages.DEVICE_RUNNING;

public class MovimentoZirk {

	private Bezirk bezirk;
	
	public MovimentoZirk() {
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Movimento Zirk");
	}
	
	public void start() {
		MovimentoZirk movimentoZirk = new MovimentoZirk();
		//System.err.println("This product has a Moviment Sensor");
		
		System.err.println(I18N.getString(DEVICE_RUNNING, "Moviment Sensor"));
		movimentoZirk.activityDetected();
	}

	private void activityDetected() {
		final boolean mov = true;
		final MovimentoEvento movimentoEvento= new MovimentoEvento(mov);
		bezirk.sendEvent(movimentoEvento);
		System.err.println("Published moviment detection: " + movimentoEvento.toString());
	}
	
	
	
}
