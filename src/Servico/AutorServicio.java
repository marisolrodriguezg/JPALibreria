package Servico;

import Entidades.Autor;
import Persistencia.AutorDAO;

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

    public boolean eliminarPorId(String id) {
        try {
            DAO.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //punto 8 

    public Autor buscarPorNombre(String nombre) {
        try {
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
