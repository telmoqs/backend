package br.ufg.inf.venda.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
public class Endereco implements Comparable<Endereco> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private Municipio municipio = new Municipio();

	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private Boolean ativo = true;

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Transient
	public String getEndereco() {
		String end = String.format("%s %s %s CEP: %s - %s", getLogradouro(), getNumero(), getBairro(), getCep(), getMunicipio());
		return end.toUpperCase();
	}

	@Override
	public int compareTo(Endereco o) {
		if (o != null && o.getId() != null && getId() != null) {
			return getId() - o.getId();
		} else {
			return 0;
		}
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? super.hashCode() : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().equals(getClass())) {
			return obj.hashCode() == hashCode();
		} else {
			return false;
		}
	}

}
