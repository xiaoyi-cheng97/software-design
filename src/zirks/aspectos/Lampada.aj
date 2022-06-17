package zirks.aspectos;

import static i18n.Messages.HAS_DEVICE;

import i18n.I18N;
import zirks.actores.LampadaZirk;

public aspect Lampada {

	
	before() : execution(* *.main(..)) {
		System.err.println(I18N.getString( HAS_DEVICE, "Light Sensor"));
	}
	
	pointcut changeStatus():
        execution(* *start(..));

	
	
    after() :changeStatus(){
    	LampadaZirk lz = new LampadaZirk();
    	lz.run();
    }
	
	
	
}
