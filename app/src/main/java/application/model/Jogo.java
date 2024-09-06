package application.model;
import java.utill.HashSet;

import javax.annotation.processing.Generated;

import java.lang.annotation.Inherited;
import java.util.Set;

import jakarta.persitence.Column;
import jakarta.persitence.Entity;
import jakarta.persitence.GeneratedValue;
import jakarta.persitence.GerantionType;
import jakarta.persitence.Id;
import jakarta.persitence.OneToMany;
import jakarta.persitence.Table;

@Entity
@Table (name = "jogo")
public class  Jogo{
    @Titulo 
    @GeneratedValue(strategy= GerationType.IDENTIFY)
    private long Titulo;

    @Column(unique = true, nullable = false)
    private String nome;

public void setTitulo(long titulo) {
    Titulo = titulo;

}

public long getTitulo() {
    return Titulo;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getNome() {
    return nome;
}

}

