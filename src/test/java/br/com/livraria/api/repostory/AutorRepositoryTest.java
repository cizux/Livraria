package br.com.livraria.api.repostory;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.livraria.api.model.Autor;
import br.com.livraria.api.repository.AutorRepository;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository Repository;

    @Test
    public void SalvarTest() { 
         Autor autor = new Autor();
         autor.setNome("Maria teste");
         autor.setNacionalidade("Brasil teste");
         autor.setDataNascimento(LocalDate.of(1951, 1, 31));
         var autorSalvo = Repository.save(autor);
         assertNotNull(autorSalvo.getId());

         System.out.println("Autor salvo com sucesso" + autorSalvo);
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("0e7cc403-6108-4a48-85ed-5f408065fdb5");

        Optional<Autor> possivelAutor = Repository.findById(id);

        if(possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            
            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));
            Repository.save(autorEncontrado);

            //System.out.println("Autor atualizado com sucesso" + autorEncontrado);
        } else {
            System.out.println("Autor não encontrado");
        }

       
    }

}
