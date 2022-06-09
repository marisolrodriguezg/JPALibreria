package Servico;

import Entidades.Autor;
import Persistencia.AutorDAO;
import java.util.List;

public class AutorServicio {

    private EditorialServicio editorialServicio;
    private LibroServicio libroServicio;
    private AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();

    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();
        try {

            autor.setNombre(nombre);
            
            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean eliminarPorId(Integer id) {
        try {
            DAO.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //punto 8 

    public List <Autor> buscarPorNombre(String nombre) {
        try {
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void imprimirAutorNombre(String nombre) {
        List<Autor> autores = buscarPorNombre(nombre);
        for (Autor autor: autores) {
            System.out.println(autor.toString());

        }
    }
    

    public List<Autor> listarAutores() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//    imprimir list 

    public void imprimirAutor() {
        List<Autor> autores = listarAutores();
        for (Autor autor: autores) {
            System.out.println(autor.toString());

        }
    }
     public Autor buscarPorId(Integer id) {
        try {
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
