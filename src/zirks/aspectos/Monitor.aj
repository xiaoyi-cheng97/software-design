package zirks.aspectos;

import i18n.I18N;
import i18n.Messages;


import zirks.sensores.MonitorZirk;

public aspect Monitor {
	
	before() : execution(* *.main(..)) {
		System.err.println(I18N.getString( Messages.HAS_DEVICE, "Monitor Zirk"));
	}
	
	pointcut getInputFromUser():
        call(* *.getUserInput(..));

	before() : execution(* *.getUserInput(..)){
		System.out.println(I18N.getString(Messages.MONITOR_EVENT_OPT));
	}
	
    after() returning(String r) :getInputFromUser(){
    	if (r.equals("7")) {
    		MonitorZirk mz = new MonitorZirk();
    		try {
    			mz.start();
			} catch (Exception e) {
				System.err.println(e.toString());
			}
    		
    	}
    }
}
