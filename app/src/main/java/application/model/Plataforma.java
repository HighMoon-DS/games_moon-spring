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
@Table (name = "plataforma")
public class  Plataforma{
    @nome 
    @GeneratedValue(strategy= GerationType.IDENTIFY)
    private long nome;

    @Column(unique = true, nullable = false)
    private String nome;

public void setnome(long nome) {
    nome = nome;

}

public long getnome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getNome() {
    return nome;
}

}

