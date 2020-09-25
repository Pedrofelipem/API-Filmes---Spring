package br.com.produtora.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="filme_id")
	private Long id;
	
	@NotEmpty(message="O titulo é obrigatório!")
	private String titulo;
	
	@NotEmpty(message="A data de lançamento é obrigatória!")
	private String dataLancamento;
	
	@NotEmpty(message="A sinopse é obrigatória!")
	private String sinopse;
	
	@JsonIgnoreProperties("filmes")
	@NotNull(message="O gênero é obrigatória!")
	@OneToOne
	private Genero genero;
	
	@JsonIgnoreProperties("filmes")
	@NotNull(message="O filme não pode ser criado sem nenhum ator!")
	@ManyToMany
	private List<Ator> atores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
