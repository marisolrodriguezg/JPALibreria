
package Persistencia;

import Entidades.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AutorDAO extends DAO<Autor> {

    public void editar(Autor autor) {
        super.editar(autor);
    }

    
   public void guardar(Autor autor) {
        super.guardar(autor);
    }
    public Autor buscarPorId(Integer id) throws Exception {
        
        conectar();
        Autor autor = em.find(Autor.class, id);
        //Autor autor = (Autor) em.createQuery("SELECT m FROM Autor m WHERE m.id LIKE :id").setParameter("id", id).getSingleResult();
       
        desconectar();
        return autor;

//        conectar();
//        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
//        desconectar();
//        return autor;
    }
    //punto 8
        public List<Autor> buscarPorNombre(String nombre) throws Exception {
        conectar();
        List<Autor> autores=  em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return autores;
    }

     public void eliminar(Integer id) throws Exception {
        Autor autor= buscarPorId(id);
        super.eliminar(autor);
    }
       public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores= em.createQuery("SELECT a FROM Autor a ").getResultList();
        return autores;
}
}
