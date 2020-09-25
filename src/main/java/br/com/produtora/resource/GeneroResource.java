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

import br.com.produtora.domain.Genero;
import br.com.produtora.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroResource {
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public List<Genero> listar() {
		return this.generoService.listar();
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Genero> pesquiarPorId(@PathVariable("id") Long id) {
		return this.generoService.pesquisarPorId(id)
				.map(genero -> ResponseEntity.ok(genero))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Genero> salvar(@Validated @RequestBody Genero genero) {
		Genero generoSalvar = this.generoService.salvar(genero);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(generoSalvar.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Genero atualizar(@Validated @RequestBody Genero genero) {
		return this.generoService.atualizar(genero);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Genero genero) {
		this.generoService.remover(genero);
	}
	
	@DeleteMapping(value="{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.generoService.removerPorId(id);
	}
}
