package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Url {

	@Column(name="nome_site")
	String nome;
	String endereco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
