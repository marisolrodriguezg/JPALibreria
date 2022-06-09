
package Persistencia;

import Entidades.Editorial;



public class EditorialDAO extends DAO<Editorial> {

    
    public void eliminar(Editorial edito) {
        super.eliminar(edito);
    }

    public void editar(Editorial edito) {
        super.editar(edito);
    }

    
    public void guardar(Editorial edito) {
        super.guardar(edito);
    }
      public Editorial buscarPorNombre(String nombre) throws Exception {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    
}
        public void eliminar(String id) throws Exception {
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }
         public Editorial buscarPorId(String id) throws Exception {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id").setParameter("id", id).getSingleResult();
        desconectar();
        return editorial;
    }
}
