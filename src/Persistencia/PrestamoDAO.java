
package Persistencia;

import Entidades.Prestamo;
import java.util.List;


public class PrestamoDAO extends DAO<Prestamo>{ {
    
}
      public void guardar(Prestamo prestamo) {
        super.guardar(prestamo);
    }

    public void editar(Prestamo prestamo) {
        super.editar(prestamo);
    }

     public Prestamo buscarPorId(Integer id) throws Exception {
                conectar();
        Prestamo prestamo = em.find(Prestamo.class, id);
        
        desconectar();
        return prestamo;

    }
    public void eliminar(Integer id) throws Exception {
        Prestamo prestamo=buscarPorId(id);
        super.eliminar(prestamo); 
    }

    public List<Prestamo> listarTodos() {
       conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p ").getResultList();
        return prestamos;
    }
    
     public List<Prestamo> buscarPorCliente(Integer id) throws Exception {
        conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.id LIKE :id").setParameter("id", id).getResultList();
        desconectar();
        return prestamos;
    }
    
}
