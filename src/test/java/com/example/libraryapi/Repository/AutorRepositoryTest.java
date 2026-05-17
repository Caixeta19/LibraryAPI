package com.example.libraryapi.Repository;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.repositories.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {


    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setName("Clarice Lispector");
        autor.setNacionalidade("Ucraniana");
        autor.setDataNascimento(LocalDate.of(1920, 12, 10));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo com sucesso!" + autorSalvo);
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("52577a74-269d-48cd-b739-d530a8f4e31b");

        Optional<Autor> possivelAutor = repository.findById(id);
        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1950, 5, 12));

            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTest() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Contagem de autores: " + repository.count());

    }
 @Test
    public void deletePorIDTest(){
           var id = UUID.fromString("52577a74-269d-48cd-b739-d530a8f4e31b");
           repository.deleteById(id);

       }
@Test
public void deleteTest(){
        var id = UUID.fromString("842f3a96-516e-453e-883e-feed3c616c30");
        var clarice = repository.findById(id).get();
        repository.delete(clarice);
}

}


