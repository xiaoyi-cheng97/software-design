package zirks.sensores;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import i18n.I18N;
import zirks.events.MonitorEvento;

import static i18n.Messages.DEVICE_RUNNING;

public class MonitorZirk {

	private Bezirk bezirk;
	
	//duvida: este é o vestível e o moviemnto é um sensor externo, right? tipo a cena dos bebes
	public MonitorZirk() {		
		BezirkMiddleware.initialize();
		bezirk = BezirkMiddleware.registerZirk("Monitor Zirk");
	}

	
	public void start() throws InterruptedException {
		MonitorZirk monitorZirk = new MonitorZirk();
       // System.err.println("This product has an Movement Monitor Sensor");
        
        System.err.println(I18N.getString(DEVICE_RUNNING, "Monitor Sensor"));
        monitorZirk.sendActivity();
		
	}


	private void sendActivity() {
		final double altura = 0.1;
		final double velocidade = 0.6;
		
		final MonitorEvento monitorEnvento= new MonitorEvento(altura, velocidade);
		bezirk.sendEvent(monitorEnvento);
		System.err.println("Published moviment detection: " + monitorEnvento.toString());
		
	}

}
