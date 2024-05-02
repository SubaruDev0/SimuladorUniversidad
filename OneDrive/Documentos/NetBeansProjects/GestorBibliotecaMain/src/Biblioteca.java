import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public List<Libro> libros;

       Biblioteca() {
        libros = new ArrayList<>();
    }

     void añadirLibro(Libro libro) {
        libros.add(libro);
    }
          void prestarLibro(Libro libro) {
        libros.remove(libro);
    }

public int buscarLibroPorAutor(Autor autor) {
    int contador = 0;
    for (Libro libro : libros) { //for each  (tipo elemento : colección) sirve para recorrer toda la lista
        List<Autor> autores = libro.autores;
        for (Autor a : autores) {
            if (a.nombre.equals(autor.nombre) && a.apellido.equals(autor.apellido)) {
                contador++;
            }
        }
    }
    return contador;
}

        int buscarLibroPorTitulo(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);

            if (libro.titulo.equals(titulo)) {
                return i;
            }
        }

        return -1;
    }

        int cantidadDeLibros() {
        return libros.size();
    }

    }


