
package libreria;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import static Entidades.Libro_.autor;
import static Entidades.Libro_.editorial;
import Servico.AutorServicio;
import Servico.EditorialServicio;
import Servico.LibroServicio;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Libreria {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//Menu menu=new Menu();
//     
//        menu.ejecucion();
     AutorServicio as=new AutorServicio();
      LibroServicio ls=new LibroServicio();
        EditorialServicio es= new EditorialServicio();
   //as.crearAutor("Esteban");
     //   as.eliminarPorId("1");
//     es.crearEditorial("uno");
//  Autor a1= as.buscarPorNombre("Esteban");
//  Editorial e1=es.buscarPorNombre("uno");
//    
    // as.eliminarPorId(1);
   // ls.eliminarPorISBN(2);
// ls.crearLibro("LibroCuatro", 1000, 50, 5, a1, e1);
//  ls.crearLibro("LibroCinco", 1000, 50, 5, a1, e1);
 //ls.eliminarPorISBN("2");
  // Libro l1=ls.buscarPorAotor("Esteban");

//ls.eliminarPorTitulo("LibroUno");
//ls.imprimirLibros();
//        System.out.println("-----------------------------------------------");
//ls.imprimirPorIsbn(3);
//        System.out.println("......");
//ls.imprimirPorId(3);

//ls.eliminarPorISBN("2");
//as.eliminarPorId("1");
//es.eliminarPorID("1");
//System.out.println("------------------------------------");
//ls.imprimirPorTitulo("LibroUno");

//        System.out.println("---------------");

  // ls.imprimirPorEditorial(1);
//  System.out.println("ingresar clave");
//   String clave = leer.next();
//   ls.identificarClave(clave);
   ls.imprimirPorAutor("Esteban");
   //ls.imprimirPorEditorialN("uno");
  //    ls.imprimirPorAutor("Esteban");
    }

    
    
}
