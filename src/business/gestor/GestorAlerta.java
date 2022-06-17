package business.gestor;

import java.util.Iterator;
import java.util.List;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

import business.contacto.Contacto;
import business.contacto.ContactoCatalogo;
import facade.IO.OutputFormater;
import zirks.events.AlertaEvento;
import zirks.events.BotaoEvento;
import zirks.events.MonitorEvento;
import zirks.events.MovimentoEvento;

public class GestorAlerta {

	private static GestorAlerta gestorAlerta = null;
	
	
	private Bezirk bezirk;
	

	private ContactoCatalogo db = ContactoCatalogo.getInstance();
	
	
	private GestorAlerta() {
	
		System.out.println("Gestor Alerta");

		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Handler ALert Zirk");
		System.err.println("Got Bezirk instance");
		final EventSet warningEvents = new EventSet(BotaoEvento.class, MonitorEvento.class, MovimentoEvento.class);
		warningEvents.setEventReceiver(new EventSet.EventReceiver() {

			@Override
			public void receiveEvent(Event event, ZirkEndPoint arg1) {
				if (event instanceof BotaoEvento) {
					//System.out.println(event.toString());
					BotaoEvento eventoBotao = (BotaoEvento)event;
					System.out.println(eventoBotao.toString());
					sendSMS(eventoBotao.toString());
					sendAlertEvent(eventoBotao.toString());
				}

				if (event instanceof MonitorEvento) {
					compareEvents((MonitorEvento) event);
				}
			}
		});
		bezirk.subscribe(warningEvents);
	}

	
	/**
	 *  Lazily create the instance when it is 
	 *  accessed for the first time
	 */
	public static GestorAlerta getInstance() {
		if(gestorAlerta == null)
			gestorAlerta = new GestorAlerta();
		return gestorAlerta;
	}


	public static void main(String[] args) {
		GestorAlerta gestor = new GestorAlerta();
	}

	
	/**
	 * If the given inactivity event matches with a saved 
	 * inactivity pattern, an alert event and an external
	 * message are sent
	 * @param event The inactivity event
	 */
	private void compareEvents(MonitorEvento event) {
		
	}
	

	/**
	 * Creates an Alert event with the given event and sends it
	 * @param event The event
	 */
	private void sendAlertEvent(String event) {
		bezirk.sendEvent(new AlertaEvento(event));
	}
	

	/**
	 * Sends an external message to each emergency contact, with its name, 
	 * its number and the given message
	 * @param ae The message
	 */
	private void sendSMS(String msg) {
		Iterator<Contacto> cc = db.getContactos();
		while (cc.hasNext()) {
			OutputFormater.sendSMS(cc.next().getNome(), cc.next().getNumero(), msg);
		}
	}
}
