package Persistencia;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO<Libro> {

    public void eliminar(long isbn) throws Exception {
        Libro libro = buscarPorIsnb(isbn);
        super.eliminar(libro);
    }

    public void eliminarPorTitulo(String titulo) throws Exception {
        Libro libro = buscarPorTitulo(titulo);
        super.eliminar(libro);
    }
   //punto 9 busca QUERY + SING
    public Libro buscarPorId(long id) throws Exception {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn").setParameter("isbn", id).getSingleResult();
        desconectar();
        return libro;
    }

  

    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public void editar(Libro libro) {
        super.editar(libro);
    }
//    imprimir list 

    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l ").getResultList();
        return libros;
    }
    //punto 9 buscaFIND

    public Libro buscarPorIsnb(long isnb) throws Exception {
        conectar();
        Libro libro = em.find(Libro.class, isnb);

        desconectar();
        return libro;

    }

    //punto 10 (3)
    public Libro buscarPorTitulo(String titulo) throws Exception {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo").setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }

    //punto 11 (ver si esta bien la consulta nombre: autor)
    public List <Libro> buscarPorAutor(String nombre) throws Exception {
        conectar();
       List <Libro> libros =em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }

    //punto 12 
    public List <Libro> buscarPorEditorial(Integer id) throws Exception {
        conectar();
        List <Libro> listaLibros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id =:id").setParameter("id", id).getResultList();
        
        desconectar();
        return listaLibros;
    }
 public List <Libro> buscarPorEditorialN(String nombre) throws Exception {
        conectar();
        List <Libro> listaLibros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        
        desconectar();
        return listaLibros;
    }
    /*
    Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn).getSingleResult();
     */
    //Autor autor = (Autor) em.createQuery("SELECT m FROM Autor m WHERE m.id LIKE :id").setParameter("id", id).getSingleResult();
//        em.getTransaction().begin();
//        //Borramos el alumno
//        em.remove(libro);
//        em.getTransaction().commit();
}
