package br.com.livraria.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.api.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

}
