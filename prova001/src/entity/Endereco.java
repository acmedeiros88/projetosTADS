package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	private int idEndereco;
	private String rua;
	private int numero;
	private String complemento;

	public Endereco() {

	}

	public Endereco(String rua, int numero, String complemento) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
