package Servico;

import Entidades.Cliente;
import Persistencia.ClienteDAO;
import java.util.List;

public class ClienteServicio {

    private ClienteDAO DAO;
    
    public ClienteServicio() {
        this.DAO = new ClienteDAO();
    }
    
    public Cliente crearCliente(Long documento, String nombre, String apellido, String telefono) {
        
        Cliente cliente = new Cliente();
        
        try {
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDocumento(documento);
            cliente.setTelefono(telefono);
            DAO.guardar(cliente);
            return cliente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
        public List<Cliente> buscarPorNombre(String nombre) {
        try {
            return DAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void imprimirClienteNombre(String nombre) {
        List<Cliente> clientes = buscarPorNombre(nombre);
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());

        }
    }

     public Cliente buscarPorId(Integer id) {
        try {
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    public void imprimirPorId(Integer id) {

        Cliente cliente = buscarPorId(id);
        System.out.println(cliente.toString());

    }
        public List<Cliente> listarClientes() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//    imprimir list 

    public void imprimirClientes() {
        List<Cliente> clientes = listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());

        }
    }
}
