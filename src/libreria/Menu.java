package libreria;

import Entidades.Autor;
import Entidades.Editorial;
import Servico.AutorServicio;
import Servico.EditorialServicio;
import Servico.LibroServicio;
import java.util.Scanner;

public class Menu {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorServicio as = new AutorServicio();
    LibroServicio ls = new LibroServicio();
    EditorialServicio es = new EditorialServicio();

    public void menu() {
        try {

            Integer operacion;
            do {
                System.out.println("----------------------------------");
                System.out.println("ingrese la opcion que desee?} " + "\n 1) Ingresar libro al sistema"
                        + "\n 2) listar libros " + "\n 3) listar autores " + "\n 4) listar editoriales"
                        + "\n 5) Búsqueda de un Autor por nombre." + "\n 6) Búsqueda de un libro por ISBN. "
                        + "\n 7) Búsqueda de un libro por Título." + "\n 8) Búsqueda de un libro/s por nombre de Autor."
                        + "\n 9) Búsqueda de un libro/s por nombre de Editorial" + "\n 10) Salir");

                System.out.println("--------------------------------");

                operacion = numInt();
                switch (operacion) {
                    case 1:
                        System.out.println("ingrese el titulo del libro");
                        String titulo = palabraString();
                        ls.crearLibro(titulo, 1000, 10, 5, queAutor(), queEditorial());
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
                        
                        long buscarIsnb =  numLong();
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

            } while (operacion == 0);

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
        es.imprimirEditorial();
        System.out.println("a)elegir EDITORIAL existente // b)crear nueva EDITORIAL");
        String opEdit = leer.next();
        if (opEdit.equalsIgnoreCase("a")) {
            System.out.println("ingrese el nombre de la editorial elegida");
            nomEdit = es.buscarPorNombre(palabraString());

        } else {

            System.out.println("ingrese el nombre la editorial nueva ");

            nomEdit = es.crearEditorial(palabraString());
        }
        return nomEdit;
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
            return null;
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
