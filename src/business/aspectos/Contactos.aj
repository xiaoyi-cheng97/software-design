package business.aspectos;


import java.util.Iterator;
import java.util.Scanner;

import business.contacto.Contacto;
import business.contacto.ContactoCatalogo;
import i18n.I18N;
import i18n.Messages;
import zirks.actores.LampadaZirk;

public aspect Contactos {
	
	
	before() : execution(* *.getUserInput(..)){
		System.out.println(I18N.getString(Messages.NEW_CONTACT_OPT));
		System.out.println(I18N.getString(Messages.DELETE_CONTACT_OPT));
		System.out.println(I18N.getString(Messages.CONTACTS_OPT));
	}

	pointcut getInputFromUser():
        call(* facade.core.IoT.getUserInput(..));

    after() returning(String r) :getInputFromUser(){
	    	switch(r) {
	    	
	    	case "0":{
	    		Scanner sc = new Scanner(System.in);
				System.out.println(I18N.getString(Messages.CONTACT_NAME));
				String nome = sc.nextLine();
				System.out.println(I18N.getString(Messages.CONTACT_NUMBER));
				String numero = sc.nextLine();
				ContactoCatalogo.getInstance().addContacto(new Contacto(nome, Integer.parseInt(numero)));
				System.out.println(I18N.getString(Messages.CONTACT_CREATED));
	    		break;
	    	}
	    	case "1":{
	    		Scanner sc = new Scanner(System.in);
				System.out.println(I18N.getString(Messages.CONTACT_NAME));
				String nome = sc.nextLine();
				ContactoCatalogo.getInstance().deleteContacto(nome);
				System.out.println(I18N.getString(Messages.CONTACT_DELETED));
	    		break;
	    	}
	    	case "2":{
	    		Iterator<Contacto> i = ContactoCatalogo.getInstance().getContactos();
	    		while (i.hasNext()) {
					System.out.println(i.next().toString());	
				}
	    		break;
	    	}
    	}
    }
    
 
}
