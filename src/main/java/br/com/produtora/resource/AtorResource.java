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

import br.com.produtora.domain.Ator;
import br.com.produtora.service.AtorService;

@RestController
@RequestMapping("/atores")
public class AtorResource {

	@Autowired
	private AtorService atorService;
	
	@GetMapping
	public List<Ator> listar() {
		return this.atorService.listar();
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Ator> pesquisarPorId(@PathVariable("id") Long id) {
		return this.atorService.pesquisarPorId(id)
				.map(ator -> ResponseEntity.ok(ator))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Ator> salvar(@Validated @RequestBody Ator ator) {
		Ator atorSalvar = this.atorService.salvar(ator);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(atorSalvar.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Ator atualizar(@Validated @RequestBody Ator ator) {
		return this.atorService.atualizar(ator);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Ator ator) {
		this.atorService.remover(ator);
	}
	
	@DeleteMapping(value="{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.atorService.removerPorId(id);
	}
}
