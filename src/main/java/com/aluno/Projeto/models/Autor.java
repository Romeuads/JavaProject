package com.aluno.Projeto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Autor.TABLE_NAME)
public class Autor {

    public static final String TABLE_NAME = "autor";

    public interface CreateAutor {}
    public interface UpdateAutor {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreateAutor.class)
    @NotEmpty(groups = CreateAutor.class)
    @Size(groups = CreateAutor.class, min = 2, max = 100)
    private String nome;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    @NotNull(groups = CreateAutor.class)
    @NotEmpty(groups = CreateAutor.class)
    @Size(groups = CreateAutor.class, min = 5, max = 150)
    private String email;

    public Autor() {
    }

    public Autor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Autor(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return id != null && id.equals(autor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
