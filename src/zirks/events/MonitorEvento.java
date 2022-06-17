package zirks.events;

import com.bezirk.middleware.messages.Event;

public class MonitorEvento extends Event {
	
	private static final long serialVersionUID = 4561L;
	
	private final double altura;
	private final double velocidade;
	
    public MonitorEvento(double altura, double velocidade) {
        this.altura = altura;
        this.velocidade = velocidade;
    }

    public double getAltura() {
		return altura;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public String toString() {
        return String.format("Mudanca brusca de posicao: altura: " + altura 
        		+ ", velocidade: " + velocidade);

    }
}
