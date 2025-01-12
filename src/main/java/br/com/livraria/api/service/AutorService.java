package br.com.livraria.api.service;

import org.springframework.stereotype.Service;

import br.com.livraria.api.model.Autor;
import br.com.livraria.api.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
}
