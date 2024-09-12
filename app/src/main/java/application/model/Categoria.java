package application.model;

import jakarta.persistence.Column; // Corrigido
import jakarta.persistence.Entity; // Corrigido
import jakarta.persistence.GeneratedValue; // Corrigido
import jakarta.persistence.GenerationType; // Corrigido
import jakarta.persistence.Id; // Corrigido
import jakarta.persistence.OneToMany; // Corrigido
import jakarta.persistence.Table; // Corrigido
import java.util.HashSet; // Corrigido

@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Corrigido
    private long id;
    
    @Column(unique = true, nullable = false)
    private String nome;

    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
