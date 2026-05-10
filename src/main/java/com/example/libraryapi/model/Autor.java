package com.example.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name= "Autor")
@ToString
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.UUID)
    private UUID id;

    @Column(name = "name",length = 100, nullable = false)
    private String name;

    @Column(name = "data_nascimento",nullable = false)
    private LocalDate dataNascimento;

    @Column(name="nacionalidade",length = 100,nullable = false)
    private String nacionalidade;

    //@OneToMany(mappedBy = "autor")
    @Transient
    private List<Livro> livros;
}
