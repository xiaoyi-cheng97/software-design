package zirks.events;

import com.bezirk.middleware.messages.Event;

public class MovimentoEvento extends Event{

	private static final long serialVersionUID = 4564856L;
	
	private final boolean mov;
	
    public MovimentoEvento(boolean mov) {
        this.mov = mov;
    }

	public boolean getMov() {
		return mov;
	}

	public String toString() {
		if (mov) {
			return String.format("Foi detectado movimento");
		} else {
			return String.format("Nao foi detectado movimento");
		}

    }
}
