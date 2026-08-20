package com.aluno.Projeto.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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
@Table(name = Livro.TABLE_NAME)
public class Livro {

    public static final String TABLE_NAME = "livro";

    public interface CreateLivro {}
    public interface UpdateLivro {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 200, nullable = false)
    @NotNull(groups = CreateLivro.class)
    @NotEmpty(groups = CreateLivro.class)
    @Size(groups = CreateLivro.class, min = 2, max = 200)
    private String titulo;

    @Column(name = "isbn", length = 20, nullable = false, unique = true)
    @NotNull(groups = CreateLivro.class)
    @NotEmpty(groups = CreateLivro.class)
    @Size(groups = CreateLivro.class, min = 10, max = 20)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    @NotNull(groups = CreateLivro.class)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editora_id", nullable = false)
    @NotNull(groups = CreateLivro.class)
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @NotNull(groups = CreateLivro.class)
    private Categoria categoria;

    public Livro() {
    }

    public Livro(String titulo, String isbn, Autor autor,
                 Editora editora, Categoria categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
    }

    public Livro(Long id, String titulo, String isbn, Autor autor,
                 Editora editora, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return id != null && id.equals(livro.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
