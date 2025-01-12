package br.com.livraria.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.api.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

    
}