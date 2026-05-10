package com.example.libraryapi.Repository;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.repositories.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {


    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setName("Clarice Lispector");
        autor.setNacionalidade("Ucraniana");
        autor.setDataNascimento(LocalDate.of(1920,12,10));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo com sucesso!" + autorSalvo);
    }
        @Test
        public void atualizarTest(){
          var id = UUID.fromString("52577a74-269d-48cd-b739-d530a8f4e31b");

           Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1950,5,12));

            repository.save(autorEncontrado);
        }


        }



    }


