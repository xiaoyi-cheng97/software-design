package zirks.events;

import com.bezirk.middleware.messages.Event;

public class AlertaEvento extends Event{
private static final long serialVersionUID = 445L;
	
	private String message;
	
	
	public AlertaEvento(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return message;
	}
}
