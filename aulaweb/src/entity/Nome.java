package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Nome {

	String primeiro;
	String segundo;
	
	public String getPrimeiro() {
		return primeiro;
	}
	public void setPrimeiro(String primeiro) {
		this.primeiro = primeiro;
	}
	public String getSegundo() {
		return segundo;
	}
	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}
	
	
}
