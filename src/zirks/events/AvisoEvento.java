package zirks.events;

import com.bezirk.middleware.messages.Event;

public class AvisoEvento extends Event{
	private String mensagem;
	private int periodo;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor with the message to show and the time of the warning
	 * @param mensagem The message associated with the warning
	 * @param hora Time the event was triggered
	 */
	public AvisoEvento(String mensagem, int periodo) {
		this.mensagem = mensagem;
		this.periodo = periodo;
	}

	/**
	 * Getter for the message
	 * @return the message associated with the warning
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * Getter for the hour of the warning
	 * @return the time the event was triggered
	 */
	public int getPeriodo() {
		return periodo;
	}
	
	/**
	 * Textual representation for the Warning Event
	 */
	public String toString() {
		return periodo + " - " + mensagem;
	}
}
