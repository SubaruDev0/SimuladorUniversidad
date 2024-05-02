import java.util.ArrayList;
import java.util.List;

public class Libro {
    public String titulo;
    public List<Autor> autores;

    public Libro(String titulo, Autor... autores) {
        this.titulo = titulo;
        this.autores = new ArrayList<>();

        for (Autor autor : autores) {
            this.autores.add(autor);
        }
    }

    Object getAutor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    }

