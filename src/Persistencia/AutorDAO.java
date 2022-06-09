
package Persistencia;

import Entidades.Autor;
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
    public Autor buscarPorId(String id) throws Exception {
        
        conectar();
        Autor autor = em.find(Autor.class, 1);
        //Autor autor = (Autor) em.createQuery("SELECT m FROM Autor m WHERE m.id LIKE :id").setParameter("id", id).getSingleResult();
        em.getTransaction().begin();
        //Borramos el alumno
        em.remove(autor);
        em.getTransaction().commit();
        desconectar();
        return autor;

//        conectar();
//        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
//        desconectar();
//        return autor;
    }
    //punto 8
        public Autor buscarPorNombre(String nombre) throws Exception {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }

     public void eliminar(String id) throws Exception {
        Autor autor= buscarPorId(id);
        super.eliminar(autor);
    }
    
}
