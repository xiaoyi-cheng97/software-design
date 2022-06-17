

import java.util.Iterator;

import business.aviso.Aviso;
import business.aviso.AvisoCalogo;
import facade.IO.OutputFormater;
import i18n.I18N;
import i18n.Messages;

public aspect Voz {
	
	before() : execution(* *.main(..)) {
		System.err.println(I18N.getString( Messages.HAS_DEVICE, "Voice Zirk"));
	}
	
	pointcut changeStatus():
        execution(* *start(..));

	
	
    after() :changeStatus(){
    	Iterator<Aviso> a = AvisoCalogo.getInstance().getAvisoToSms();
    	while (a.hasNext()) {
    		Aviso aviso = a.next();
			OutputFormater.voiceSMS(aviso.getContacto().getNome(), aviso.getContacto().getNumero(), aviso.getMsg());
			
		}
    }
}
