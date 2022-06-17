package business.aspectos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import business.aviso.Aviso;
import business.aviso.AvisoCalogo;
import business.aviso.AvisosTimer;
import facade.IO.OutputFormater;
import i18n.I18N;
import i18n.Messages;
import i18n.Messages.*;
import zirks.actores.LampadaZirk;

import zirks.events.AvisoEvento;

public aspect AvisoAj {
	before() : execution(* *.getUserInput(..)){
		System.out.println(I18N.getString(Messages.NEW_WARNING_OPT));
		System.out.println(I18N.getString(Messages.DELETE_WARNING_OPT));
	}
	
	
	pointcut changeStatus():
        execution(* *start(..));

	
	
    after() :changeStatus(){
    	Iterator<Aviso> a = AvisoCalogo.getInstance().getAvisoToSms();
    	while (a.hasNext()) {
    		Aviso aviso = a.next();
			OutputFormater.sendSMS(aviso.getContacto().getNome(), aviso.getContacto().getNumero(), aviso.getMsg());
			
		}
    }

	pointcut getInputFromUser():
        call(* facade.core.IoT.getUserInput(..));

    after() returning(String r) :getInputFromUser(){
	    	switch(r) {
	    	
	    	case "3":{
	    		Scanner sc = new Scanner(System.in);
	    		System.out.println(I18N.getString(Messages.WARNING_MSG));
	    		String msg = sc.nextLine();
	    		System.out.println(I18N.getString(Messages.START_DATE));
	    		String sd = sc.nextLine();
	    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    		LocalDateTime inicio = LocalDateTime.parse(sd, formatter);
	    		System.out.println(I18N.getString(Messages.END_DATE));
	    		String ed = sc.nextLine();
	    		LocalDateTime fim = LocalDateTime.parse(ed, formatter);
	    		System.out.println(I18N.getString(Messages.PERIOD));
	    		int periodo = Integer.parseInt(sc.nextLine());
	    		System.out.println(I18N.getString(Messages.CONTACT_NAME));
	    		String nome = sc.nextLine();
	    		
	    		Aviso a = new Aviso(msg, inicio, fim, periodo, nome);
	    		
	    		AvisoEvento ae = new AvisoEvento(msg, periodo);
	    		AvisoCalogo.getInstance().addAviso(new AvisosTimer(ae), a);
	    		
	    		break;
	    	}
	    	case "4":{
	    		
				System.out.println(I18N.getString(Messages.SHOW_WARNING));
				List<String> aviso = AvisoCalogo.getInstance().getAvisos();
				for (String a : aviso) {
					System.out.println(a);
				}
	    		Scanner sc = new Scanner(System.in);
				String idApagar = sc.nextLine();
				int id = Integer.valueOf(idApagar);
				try {
					AvisoCalogo.getInstance().deleteAviso(id);
				} catch (Exception e) {
					System.err.println(I18N.getString(Messages.NO_WARNING));
				}
				
				System.out.println(I18N.getString(Messages.WARNING_DELETED));
				break;
	    	}
	    	
    	}
    }
    
    
    
}
