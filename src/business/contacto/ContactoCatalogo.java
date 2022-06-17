package business.contacto;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.shiro.crypto.hash.Hash;

public class ContactoCatalogo {

	private static ContactoCatalogo instance;
	
	HashMap<String, Contacto> contacto;
			
	public ContactoCatalogo() {
		this.contacto = new HashMap<String, Contacto>();
	}
	
	public void addContacto(Contacto c) {
		
		contacto.put(c.getNome(), c);
		
	}
	
	public void deleteContacto(String nome) {
		contacto.remove(nome);
	}
	
	public Contacto getContacto(String nome) {
		return contacto.get(nome);
	}
	
	public  Iterator<Contacto> getContactos(){
		return contacto.values().iterator();
	}

	public static ContactoCatalogo getInstance() {
		if (instance == null) {
			instance = new ContactoCatalogo();
		}
		
		return instance;
	}
	
}
