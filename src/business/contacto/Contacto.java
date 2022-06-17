package business.contacto;

public class Contacto {

	private String nome;
	private int numero;
	
	public Contacto(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + ": " + numero + "\n");
		return sb.toString();
	}
}
