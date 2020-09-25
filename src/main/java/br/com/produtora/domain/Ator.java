package br.com.produtora.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Ator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ator_id")
	private Long id;
	
	@NotEmpty(message="O nome é obrigatório!")
	private String nome;
	
	@NotEmpty(message="A data de nascimento é obrigatória!")
	private String dataNascimento;
	
	@NotEmpty(message="O sexo obrigatória!")
	private String sexo;
	
	@NotEmpty(message="A biografia do ator é obrigatória!")
	private String biografia;
	
	@JsonIgnoreProperties("atores")
	@ManyToMany(mappedBy="atores")
	private List<Filme> filmes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
}
