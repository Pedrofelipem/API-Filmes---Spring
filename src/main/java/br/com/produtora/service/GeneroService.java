package br.com.produtora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produtora.domain.Genero;
import br.com.produtora.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public Genero salvar(Genero genero) {
		return this.generoRepository.save(genero);
	}
	public Genero atualizar(Genero genero) {
		return this.generoRepository.save(genero);
	}
	public List<Genero> listar() {
		return this.generoRepository.findAll();
	}
	public Optional<Genero> pesquisarPorId(Long id) {
		return this.generoRepository.findById(id);
	}
	public void remover(Genero genero) {
		this.generoRepository.delete(genero);
	}
	public void removerPorId(Long id) {
		this.generoRepository.deleteById(id);
	}
}
