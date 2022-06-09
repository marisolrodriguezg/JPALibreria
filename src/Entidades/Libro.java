
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static jdk.nashorn.internal.runtime.Debug.id;

@Entity
@Table(name="LIBROS")
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ISBN")
    private long isbn;
    
    @Column(name="TITULO")
    private String titulo;
    
    @Column(name="AÑO")
    private Integer anio;
    
    @Column(name="EJEMPLARES")
    private Integer ejemplares;
    
    @Column(name="EJEMPLARES_PRESTADOS")
    private Integer ejemplaresPrestados;
    
    @Column(name="EJEMPLARES_RESTANTES")
    private Integer ejemplaresRestanes;
    
    @Column(name="ALTA")
    private boolean alta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Editorial editorial;

    public Libro() {
        this.alta=true;
    }

    public Libro(long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestanes, boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestanes = ejemplaresRestanes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestanes() {
        return ejemplaresRestanes;
    }

    public void setEjemplaresRestanes(Integer ejemplaresRestanes) {
        this.ejemplaresRestanes = ejemplaresRestanes;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", anio=" + anio + ", ejemplares=" + ejemplares + ", ejemplaresPrestados=" + ejemplaresPrestados + ", ejemplaresRestanes=" + ejemplaresRestanes + ", alta=" + alta + ", autor=" + autor + ", editorial=" + editorial + '}';
    }
    
    
    
    
}
