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
@Table(name = Editora.TABLE_NAME)


public class Editora {

    public static final String TABLE_NAME = "editora";

    public interface CreateEditora {}
    public interface UpdateEditora {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreateEditora.class)
    @NotEmpty(groups = CreateEditora.class)
    @Size(groups = CreateEditora.class, min = 2, max = 100)
    private String nome;

    @Column(name = "endereco", length = 200, nullable = false)
    @NotNull(groups = CreateEditora.class)
    @NotEmpty(groups = CreateEditora.class)
    @Size(groups = CreateEditora.class, min = 5, max = 200)
    private String endereco;

    public Editora() {
    }

    public Editora(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Editora(Long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editora)) return false;
        Editora editora = (Editora) o;
        return id != null && id.equals(editora.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
