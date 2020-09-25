package br.com.produtora.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.produtora.domain.Filme;
import br.com.produtora.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping
	public List<Filme> listar() {
		return this.filmeService.listar();
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Filme> pesquisarPorId(@PathVariable("id") Long id) {
		return this.filmeService.pesquisarPorId(id)
				.map(filme -> ResponseEntity.ok(filme))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Filme> salvar(@Validated @RequestBody Filme filme) {
		Filme filmeSalvar = this.filmeService.salvar(filme);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(filmeSalvar.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Filme atualizar(@Validated @RequestBody Filme filme) {
		return this.filmeService.atualizar(filme);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Filme filme) {
		this.filmeService.remover(filme);
	}
	
	@DeleteMapping(value="{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.filmeService.removerPorId(id);
	}
}
