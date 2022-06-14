package libreria;

import Entidades.Autor;
import Entidades.Cliente;
import Entidades.Editorial;
import Entidades.Libro;
import Servico.AutorServicio;
import Servico.ClienteServicio;
import Servico.EditorialServicio;
import Servico.LibroServicio;
import Servico.PrestamoServicio;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorServicio as = new AutorServicio();
    LibroServicio ls = new LibroServicio();
    EditorialServicio es = new EditorialServicio();
    ClienteServicio cs = new ClienteServicio();
    PrestamoServicio p1 = new PrestamoServicio();

    public void menu() {
        try {

            Integer operacion;
            do {
                System.out.println("----------------------------------");
                System.out.println("ingrese la opcion que desee?} " + "\n 1) Ingresar libro al sistema"
                        + "\n 2) listar libros " + "\n 3) listar autores " + "\n 4) listar editoriales"
                        + "\n 5) Búsqueda de un Autor por nombre." + "\n 6) Búsqueda de un libro por ISBN. "
                        + "\n 7) Búsqueda de un libro por Título." + "\n 8) Búsqueda de un libro/s por nombre de Autor."
                        + "\n 9) Búsqueda de un libro/s por nombre de Editorial"
                        + "\n 10) Ingresar un cliente"
                       
                + "\n 11) ingrese un prestamo"
                 + "\n 12) Devolver Prestamo"
                + "\n 13) Salir");

                System.out.println("--------------------------------");

                operacion = numInt();
                switch (operacion) {
                    case 1:
                        System.out.println("ingrese el titulo del libro");
                        String titulo = palabraString();
                        ls.crearLibro(titulo, 1000, 10, 0, queAutor(), queEditorial());
                        System.out.println("el nuevo libro es");
                        ls.imprimirLibros();
                    case 2:
                        System.out.println("La lista de la biblioteca es ");
                        ls.imprimirLibros();
                        break;
                    case 3:
                        System.out.println("la lista de autores es ");
                        as.imprimirAutor();
                        break;
                    case 4:
                        System.out.println("la lista de editoriales es ");
                        es.imprimirEditorial();
                        break;
                    case 5:
                        System.out.println("ingrese el nombre del autor que desee buscar:");
                        String nombreAutorBuscar = palabraString();

                        as.imprimirAutorNombre(nombreAutorBuscar);
                        break;
                    case 6:
                        System.out.println("ingrese el ISBN del libro que desea buscar");

                        long buscarIsnb = numLong();
                        ls.imprimirPorIsbn(buscarIsnb);
                        break;
                    case 7:
                        System.out.println("ingrese el titulo del libro que desea buscar ");
                        String tituloBuscar = palabraString();
                        ls.imprimirPorTitulo(tituloBuscar);
                        break;
                    case 8:
                        System.out.println("escribe el nombre del autor que quiere los libros");
                        nombreAutorBuscar = palabraString();
                        ls.imprimirPorAutor(nombreAutorBuscar);
                        break;
                    case 9:
                        System.out.println("escribe el nombre de la editorial que quiere los libros");
                        String nombreEditBuscar = palabraString();
                        ls.imprimirPorEditorialN(nombreEditBuscar);
                        break;
                    case 10:
                        System.out.println("ingrese el documento, nombre, apellido, y telefono del cliente");
                        Long documento = numLong();
                        String nombre = palabraString();
                        String apellido = palabraString();
                        String telefono = palabraString();
                        cs.crearCliente(documento, nombre, apellido, telefono);
                        break;

                    case 11:
                        //System.out.println("Ingrese el dia , mes  y año del prestamo ");
                       // int diaP = numInt();
                        //int mesP = numInt();
                        //int anioP = numInt();
                        //System.out.println("Ingrese el dia , mes  y año de la devolucuion ");
                        //int diaD = numInt();
                        //int mesD = numInt();
                        //int anioD = numInt();
                        Date fechaPrestamo = new Date(2000, 01, 11);
                        Date fechaDevolucion = new Date(2000, 01, 13);
                        p1.crearPrestamo(fechaPrestamo, fechaDevolucion, queLibro(), queCliente());
                     
                       // p1.crearPrestamo(1111-01-01, 1111-11-11, queLibro(), queCliente());
                        ls.ejemplaresPrestados();
                       // p1.imprimirPrestamos();
                      
                        break;
                    case 12:
                        
                        p1.devolucion();
                        ls.ejemplaresDevultos();
                        break;
                    case 13:
                        System.out.println("¿Está seguro que desea salir del programa (S/N");

                        String si = leer.next();

                        if (si.equals("s")) {
                            System.out.println("salir del programa");
                            operacion = 0;
                            break;
                        } else {

                            if (si.equals("n")) {
                                System.out.println("continuar en el programa");
                            }
                            break;
                        }
                    default:
                        System.out.println("el num es incorrecto");

                }

            } while (operacion != 0);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

    }

    public Autor queAutor() {
        System.out.println("mostrar autores");

        Autor idAutor = null;

        System.out.println("a)elegir autor existente // b)crear nuevo autor");

        String opAutor = palabraString();

        if (opAutor.equalsIgnoreCase("a")) {
            as.imprimirAutor();
            System.out.println("ingrese el id del autor elegido");
            idAutor = as.buscarPorId(numInt());

        } else {
            if (opAutor.equalsIgnoreCase("b")) {
                System.out.println("ingrese el nombre del nuevo autor");

                idAutor = as.crearAutor(palabraString());

            }
        }

        return idAutor;
    }

    public Editorial queEditorial() {
        Editorial nomEdit = null;
        System.out.println("elige la EDITORIL del libro segun su nombre");
        
        System.out.println("a)elegir EDITORIAL existente // b)crear nueva EDITORIAL");
        String opEdit = leer.next();
        if (opEdit.equalsIgnoreCase("a")) {
            es.imprimirEditorial();
            System.out.println("ingrese el nombre de la editorial elegida");
            nomEdit = es.buscarPorNombre(palabraString());

        } else {

            System.out.println("ingrese el nombre la editorial nueva ");

            nomEdit = es.crearEditorial(palabraString());
        }
        return nomEdit;
    }

    public Libro queLibro() {

        Libro libroElegido;
        System.out.println("elige el libro que quiere ALQUILAR");
        
        ls.imprimirLibros();
        System.out.println("ingrese el num de isbn elegino");
        Long isnbElegido=numLong();
       libroElegido= ls.buscarPorIsnb(isnbElegido);
        
        return libroElegido;
    }

    public Cliente queCliente() {

        Cliente clienteElegido = null;
          
        System.out.println("elige el cliente segun su id");
        cs.imprimirClientes();
        System.out.println("a)elegir CLIENTE existente // b)crear un nuevo cliente");
        String opEdit = palabraString();
        if (opEdit.equalsIgnoreCase("a")) {
            System.out.println("ingrese el id del cliente  elegido");
           Integer numId=numInt();
         clienteElegido=cs.buscarPorId(numId);
            
        } else {

         System.out.println("ingrese el documento, nombre, apellido, y telefono del cliente");
                        Long documento = numLong();
                        String nombre = palabraString();
                        String apellido = palabraString();
                        String telefono = palabraString();
                       clienteElegido= cs.crearCliente(documento, nombre, apellido, telefono);
        }
        
        return clienteElegido;
    }

    public String palabraString() {
        try {
            String palabra = leer.next();

            return palabra;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer numInt() {
        try {
            Integer numero = leer.nextInt();

            return numero;
        } catch (Exception e) {
            System.out.println("OJO debes ingresar un num");
            System.out.println(e.getMessage());
            
            return null ;
        }
    }
    //como hacer el try para long

    public Long numLong() {
        try {
            long numero = leer.nextLong();

            return numero;
        } catch (Exception e) {
            System.out.println("OJO debes ingresar un num");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
