package zirks.events;

import com.bezirk.middleware.messages.Event;

public class BotaoEvento extends Event {

	private static final long serialVersionUID = 1555L;
	
	private final boolean click;
	
    public BotaoEvento(boolean click) {
        this.click = click;
    }

	public boolean getClick() {
		return click;
	}

	public String toString() {
		return String.format("O Botao foi accionado!");
    }
}
