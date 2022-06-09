package Servico;

import Entidades.Editorial;
import Persistencia.EditorialDAO;

public class EditorialServicio {

    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private EditorialDAO DAO;
    
    public EditorialServicio(){
        this.DAO= new EditorialDAO();
    }

    public Editorial crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        try {

            editorial.setNombre(nombre);
            editorial.setAlta(true);

            DAO.guardar(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
        public Editorial buscarPorNombre(String nombre) {
        try {
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
         public boolean eliminarPorID(String id) {
        try {
            DAO.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
