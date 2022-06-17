package business.aviso;


import java.time.LocalDateTime;

import business.contacto.Contacto;
import business.contacto.ContactoCatalogo;

public class Aviso {
	
	private String msg;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private int periodo;
	private Contacto contacto;
	
	public Aviso(String msg, LocalDateTime inicio, LocalDateTime fim, int periodo, String nome) {
		this.msg = msg;
		this.inicio = inicio;
		this.fim = fim;
		this.periodo = periodo;
		this.contacto = ContactoCatalogo.getInstance().getContacto(nome);
	}

	public String getMsg() {
		return msg;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public int getPeriodo() {
		return periodo;
	}

	public Contacto getContacto() {
		return contacto;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(LocalDateTime.now() + "-" + msg);
		return sb.toString();
	}
	
	
	
}
