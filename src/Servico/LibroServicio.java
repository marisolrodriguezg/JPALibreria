package Servico;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.LibroDAO;
import java.util.List;
import java.util.Scanner;

public class LibroServicio {

    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private LibroDAO DAO;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }

    public Libro crearLibro(String titulo, Integer anio, Integer ejemplaresTotal, Integer ejemplaresPrestado, Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {

            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplaresTotal);
            libro.setEjemplaresPrestados(ejemplaresPrestado);
            libro.setEjemplaresRestanes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            DAO.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //punto 9 busca uno solo 
    public Libro buscarPorIsnb(long isnb) {
        try {
            return DAO.buscarPorIsnb(isnb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //punto 9 busca uno solo 
    public void imprimirPorIsbn(long isbn) {

        Libro libro = buscarPorIsnb(isbn);
        System.out.println(libro.toString());

    }
    //punto 9 busca uno solo 

    public void imprimirPorId(long id) {

        Libro libro = buscarPorId(id);
        System.out.println(libro.toString());

    }
    //punto 9 busca uno solo 

    public Libro buscarPorId(long id) {
        try {
            return DAO.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //punto 10 (2)
    public Libro buscarPorTitulo(String titulo) {
        try {
            return DAO.buscarPorTitulo(titulo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //punto 10 (1)
    public void imprimirPorTitulo(String titulo) {

        Libro libro = buscarPorTitulo( titulo);
        System.out.println(libro.toString());
        

    }

    //punto 11
    public List<Libro> buscarPorAutor(String nombre) {
        try {
            return DAO.buscarPorAutor(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void imprimirPorAutor(String nombre) {
        List<Libro> libros = buscarPorAutor( nombre);
        for (Libro libro : libros) {
            System.out.println(libro.toString());

        }
    }
    //punto 12

    public void imprimirPorEditorial(Integer id) {
        List<Libro> libros = listarLibrosEditorial(id);
//nati
        libros.stream().forEach(System.out::println);
//        for (Libro libro : libros) {
//            System.out.println(libro.toString());

    }

    public List<Libro> listarLibrosEditorial(Integer id) {
        try {

            return DAO.buscarPorEditorial(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void imprimirPorEditorialN(String nombre) {
        List<Libro> libros = listarLibrosEditorialN(nombre);

        libros.stream().forEach(System.out::println);
//        for (Libro libro : libros) {
//            System.out.println(libro.toString());

    }

    public List<Libro> listarLibrosEditorialN(String nombre) {
        try {

            return DAO.buscarPorEditorialN(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarPorISBN(long isbn) {
        try {
            DAO.eliminar(isbn);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean eliminarPorTitulo(String titulo) {
        try {
            DAO.eliminarPorTitulo(titulo);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
//    imprimir list 

    public List<Libro> listarLibros() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//    imprimir list 

    public void imprimirLibros() {
        List<Libro> libros = listarLibros();
        for (Libro libro : libros) {
            System.out.println(libro.toString());

        }
    }
//invento punto 12  convierte de String a int
    public void identificarClave(String clave) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
       // System.out.println("ingresar clave");
      // String clave = leer.next();
        boolean esNum = true;

        for (int i = 0; i < clave.length(); i++) {
            if (!Character.isDigit(clave.charAt(i))) {
                esNum = false;
                imprimirPorEditorialN(clave);
                break;
            }
            else
            {
             Integer claveNum = Integer.parseInt(clave);
             imprimirPorEditorial(claveNum);
                
            }
        }
     
    }
}


