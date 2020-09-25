package br.com.produtora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.produtora.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
