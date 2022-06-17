package zirks.aspectos;

import i18n.I18N;
import i18n.Messages;
import zirks.sensores.BotaoZirk;

public aspect Botao {
	
	before() : execution(* *.main(..)) {
		System.err.println(I18N.getString(Messages.HAS_DEVICE, "Button Sensor Zirk"));
	}
	
	pointcut getInputFromUser():
        call(* *.getUserInput(..));

	before() : execution(* *.getUserInput(..)){
		System.out.println(I18N.getString(Messages.BUTTON_EVENT_OPT));
	}
	
    after() returning(String r) :getInputFromUser(){
    	if (r.equals("5")) {
    		BotaoZirk bz = new BotaoZirk();
    		try {
    			bz.start();
    			
			} catch (Exception e) {
				System.err.println(e.toString());
			}
    		
    	}
    }
}
