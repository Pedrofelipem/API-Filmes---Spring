package br.com.produtora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.produtora.domain.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {

}
