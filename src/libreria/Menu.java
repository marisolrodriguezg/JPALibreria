
package libreria;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Servico.AutorServicio;
import Servico.EditorialServicio;
import Servico.LibroServicio;

public class Menu {
      AutorServicio as=new AutorServicio();
        LibroServicio ls=new LibroServicio();
        EditorialServicio es= new EditorialServicio();
        
        public void ejecucion(){
            
            String nombreAutor1="pepe";
            Autor a1=as.crearAutor(nombreAutor1);
            String nombreEdit1="editial1";
            Editorial e1=es.crearEditorial(nombreEdit1);
            
            Libro l1=ls.crearLibro("Naranja", a1, e1);
        }
}
