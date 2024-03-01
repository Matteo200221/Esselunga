package esselunga.jpa.models;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class Utente implements Serializable{
	
	private static final long serialVersionUID = -1533030330246399437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="COGNOME")
	private String cognome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToMany(mappedBy="utenti")
	@JsonbTransient
	private List<Prodotto> prodotti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
				+ password + ", prodotti.size=" + (prodotti != null ? prodotti.size() : 0) + "]";
	}

}
