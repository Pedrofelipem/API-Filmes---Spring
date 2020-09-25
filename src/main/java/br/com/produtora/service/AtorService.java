package br.com.produtora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produtora.domain.Ator;
import br.com.produtora.repository.AtorRepository;

@Service
public class AtorService {

	@Autowired
	private AtorRepository atorRepository;
	
	public Ator salvar(Ator ator) {
		return this.atorRepository.save(ator);
	}
	public Ator atualizar(Ator ator) {
		return this.atorRepository.save(ator);
	}
	public List<Ator> listar() {
		return this.atorRepository.findAll();
	}
	public Optional<Ator> pesquisarPorId(Long id) {
		return this.atorRepository.findById(id);
	}
	public void remover(Ator ator) {
		this.atorRepository.delete(ator);
	}
	public void removerPorId(Long id) {
		this.atorRepository.deleteById(id);
	}
}
