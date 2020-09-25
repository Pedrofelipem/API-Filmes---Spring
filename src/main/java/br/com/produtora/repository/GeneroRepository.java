package br.com.produtora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.produtora.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
