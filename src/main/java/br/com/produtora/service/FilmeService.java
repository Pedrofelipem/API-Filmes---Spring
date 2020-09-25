package br.com.produtora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produtora.domain.Filme;
import br.com.produtora.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Filme salvar(Filme filme) {
		return this.filmeRepository.save(filme);
	}
	public Filme atualizar(Filme filme) {
		return this.filmeRepository.save(filme);
	}
	public List<Filme> listar() {
		return this.filmeRepository.findAll();
	}
	public Optional<Filme> pesquisarPorId(Long id) {
		return this.filmeRepository.findById(id);
	}
	public void remover(Filme filme) {
		this.filmeRepository.delete(filme);
	}
	public void removerPorId(Long id) {
		this.filmeRepository.deleteById(id);
	}
}
