package zirks.sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import static i18n.Messages.DEVICE_RUNNING;

import i18n.I18N;
import zirks.events.BotaoEvento;

public class BotaoZirk {
	private Bezirk bezirk; 
	
	public BotaoZirk() {
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Button Sensor Zirk");
		System.err.println("Got Bezirk instance");
	}
	
	
	public void start() {
		BotaoZirk b = new BotaoZirk();
		System.err.println(I18N.getString( DEVICE_RUNNING, "Button Sensor Zirk"));
		b.update();
	}
	
	private void update() {
		final boolean click = true;
		final BotaoEvento botaoEvento = new BotaoEvento(click);
		bezirk.sendEvent(botaoEvento);
		System.err.println("Published button event: " + botaoEvento.toString());
	}
}
