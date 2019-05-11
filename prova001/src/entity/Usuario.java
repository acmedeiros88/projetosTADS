package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	private String cpf;
	private String senha;
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco endereco;

	public Usuario() {

	}

	public Usuario(String cpf, String senha, String nome, Endereco endereco) {
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
