package zirks.aspectos;

import i18n.I18N;
import i18n.Messages;
import zirks.sensores.MovimentoZirk;
import static i18n.Messages.*;

public aspect Movimento {
	
	before() : execution(* *.main(..)) {
		System.err.println(I18N.getString( Messages.HAS_DEVICE, "Moviment Zirk"));
	}
	
	pointcut getInputFromUser():
        call(* *.getUserInput(..));
	
	before(): execution(* *.getUserInput(..)){
		System.out.println(I18N.getString(Messages.MOVEMENT_EVENT_OPT));
	}

    after() returning(String r) :getInputFromUser(){
    	if (r.equals("6")) {
    		MovimentoZirk mz = new MovimentoZirk();
    		mz.start();
    	}
    }
        

}
