package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contato {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String cpf;
	
	private String tel;

	
	
	public Contato() {
		super();
	}



	public Contato( String nome, String cpf, String tel) {
	
		
		this.nome = nome;
		this.cpf = cpf;
		this.tel = tel;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	

}
