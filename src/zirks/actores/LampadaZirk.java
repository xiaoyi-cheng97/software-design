package zirks.actores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.*;

import i18n.I18N;
import i18n.Messages;
import zirks.events.AlertaEvento;
import zirks.events.AvisoEvento;
import zirks.events.BotaoEvento;
import zirks.events.MonitorEvento;
import zirks.events.MovimentoEvento;

import static i18n.Messages.DEVICE_RUNNING;

public class LampadaZirk {

	private Bezirk bezirk;
	private String cor = "WHITE";
	
	public LampadaZirk() {
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Lampada Zirk");
		
	}
	
	public void run() {
		LampadaZirk lampadaZirk = new LampadaZirk();
		
		
		System.err.println(I18N.getString(DEVICE_RUNNING, "Light Sensor"));
		lampadaZirk.changeStatus();
		
		System.err.println(I18N.getString(Messages.LIGHT_ON, cor));
		
	}
	
	private void changeStatus(){
		

		final EventSet events = new EventSet(AlertaEvento.class, 
				AvisoEvento.class, BotaoEvento.class, 
				MonitorEvento.class, MovimentoEvento.class);
				
		
		events.setEventReceiver(new EventSet.EventReceiver() {
			
			@Override
			public void receiveEvent(Event event, ZirkEndPoint arg1) {
			
				
				if (event instanceof AlertaEvento) {
					cor = "YELLOW";
				}

				if (event instanceof AvisoEvento) {
					cor = "RED";
				}
				
				if (event instanceof BotaoEvento) {
					cor = "GREEN";
				}
				
				if (event instanceof MonitorEvento) {
					cor = "PINK";
				}
				
				if (event instanceof MovimentoEvento) {
					cor = "BLUE";
				}
				
			
			}
			
		});
				
		bezirk.subscribe(events);
	}
	
	
}


