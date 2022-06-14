package Persistencia;

import Entidades.Cliente;
import java.util.List;

public class ClienteDAO extends DAO<Cliente> {

    public void guardar(Cliente cliente) {
        super.guardar(cliente);
    }

    public void editar(Cliente cliente) {
        super.editar(cliente);
    }

   

    public List<Cliente> buscarPorNombre(String nombre) throws Exception {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return clientes;
    }

    public Cliente buscarPorId(Integer id) throws Exception {
        conectar();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.id LIKE :id").setParameter("id", id).getSingleResult();
                //em.find(Cliente.class, id);

        desconectar();
        return cliente;

    }

    public List<Cliente> listarTodos() throws Exception {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT l FROM Cliente l ").getResultList();
        return clientes;
    }
}
