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
@Table (name = "categorias")
public class  Categoria{
    @Id 
    @GeneratedValue(strategy= GerationType.IDENTIFY)
    private long Id;

    @Column(unique = true, nullable = false)
    private String nome;

public void setId(long id) {
    Id = id;
}

public long getId() {
    return Id;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getNome() {
    return nome;
}

}

