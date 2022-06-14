package Servico;

import Entidades.Cliente;
import Entidades.Libro;
import Entidades.Prestamo;
import Persistencia.LibroDAO;
import Persistencia.PrestamoDAO;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrestamoServicio {

    private LibroServicio libroServicio;
    private ClienteServicio clienteServicio;
    private PrestamoDAO DAO;
    private LibroDAO DAOL;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ClienteServicio cs = new ClienteServicio();

    public PrestamoServicio() {
        this.DAO = new PrestamoDAO();
    }

    public Prestamo crearPrestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) {
        Prestamo prestamo = new Prestamo();
        try {
            prestamo.setFechaPrestamo(fechaPrestamo);
            prestamo.setFechaDevolucion(fechaDevolucion);
            prestamo.setLibro(libro);
            prestamo.setCliente(cliente);
            prestamo.setPrestado(true);

            DAO.guardar(prestamo);
            return prestamo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Prestamo> listarPrestamos() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Prestamo buscarPorId(Integer id) {
        try {
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
//    imprimir list 

    public void imprimirPrestamos() {
        List<Prestamo> prestamos = listarPrestamos();
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo.toString());

        }
    }

    public List<Prestamo> buscarPorCliente(Integer id) {
        try {
            return DAO.buscarPorCliente(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void imprimirPorCliente(Integer id) {
        List<Prestamo> prestamos = buscarPorCliente(id);
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo.toString());
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

    public Prestamo devolucion() throws Exception {
        Prestamo p;
        System.out.println("que cliente que desea devover un libro? ");
        cs.imprimirClientes();
        System.out.println("ingrese el id cliente ");
        Integer idCliente = leer.nextInt();
        imprimirPorCliente(idCliente);
        System.out.println("ingrese el id del prestamo que va a devolver ");
        Integer idEliminar = leer.nextInt();
        p = buscarPorId(idEliminar);

        p.setPrestado(false);
        DAO.guardar(p);
        System.out.println("los prestamos del cliente " + idCliente + "quedaron ");
        imprimirPorCliente(idCliente);
        return p;

    }
}
