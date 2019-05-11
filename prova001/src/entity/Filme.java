package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme {
	@Id
	@GeneratedValue
	private int codFilme;
	private String nomeFilme;
	private String anoFilme;
	private String usuario;

	public Filme() {

	}

	public Filme(String nomeFilme, String anoFilme) {
		this.nomeFilme = nomeFilme;
		this.anoFilme = anoFilme;
	}

	public Filme(String nomeFilme, String anoFilme, String usuario) {
		this.nomeFilme = nomeFilme;
		this.anoFilme = anoFilme;
		this.usuario = usuario;
	}

	public int getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(int codFilme) {
		this.codFilme = codFilme;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getAnoFilme() {
		return anoFilme;
	}

	public void setAnoFilme(String anoFilme) {
		this.anoFilme = anoFilme;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
