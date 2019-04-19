package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Contato {

	@Id
	@GeneratedValue
	private Integer id;

	
	private Nome nome;

	private String notas;

	private Url site;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Telefone> telefones = new ArrayList<>();

	private boolean favoritos;

	public Contato() {
		
	}
	
	public Contato(Nome nome, String notas, Url site, boolean favoritos) {
		this.nome = nome;
		this.notas = notas;
		this.site = site;
		this.favoritos = favoritos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome.primeiro +" " + nome.segundo;
	}

	public void setNome(Nome nome) {
		this.nome = nome;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Url getSite() {
		return site;
	}

	public void setSite(Url site) {
		this.site = site;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public boolean isFavoritos() {
		return favoritos;
	}

	public void setFavoritos(boolean favoritos) {
		this.favoritos = favoritos;
	}

}
