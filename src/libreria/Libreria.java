
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
 
  Menu menu =new Menu();
  menu.menu();
 
    }
}
