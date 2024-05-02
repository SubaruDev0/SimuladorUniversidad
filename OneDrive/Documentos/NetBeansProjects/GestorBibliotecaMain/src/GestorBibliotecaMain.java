public class GestorBibliotecaMain { // 
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca(); // 

        
        // Creación de autores
        Autor a1 = new Autor("Gabriel","Garcia Marquez");
        Autor a2 = new Autor("J.K.", "Rowling");
        Autor a3 = new Autor("Haruki", "Murakami");
        Autor a4 = new Autor("Javier", "Morales");  
        
       
        // Creación de libros
        Libro l1 = new Libro("Cien anios de soledad",a1);
        Libro l2 = new Libro("Harry Potter y la piedra filosofal",a2);
        Libro l3 = new Libro("Norwegian Wood",a3);
        Libro l4 = new Libro("Cronica de una muerte anunciada",a1);
        Libro l5 = new Libro("Tokio Blues",a3);
        Libro l6 = new Libro("Mi Libro",a4);

        
        // Añadir libros a la biblioteca
        b1.añadirLibro(l1);
        b1.añadirLibro(l2);
        b1.añadirLibro(l3);
        b1.añadirLibro(l4);
        b1.añadirLibro(l5);
        b1.añadirLibro(l6);    
        
        
        //Buscar libros por autor
        int idA1 = b1.buscarLibroPorAutor(a1);
        int idA2 = b1.buscarLibroPorAutor(a2);
        int idA3 = b1.buscarLibroPorAutor(a3);
        int idA4 = b1.buscarLibroPorAutor(a4);
        
        System.out.println("------------------------ ");
        

      
        System.out.println("Libros escritos por "+ a1.nombre+" "+a1.apellido+" en esta biblioteca: " + idA1 );
        System.out.println("Libros escritos por "+ a2.nombre+" "+a2.apellido +": " + idA2 );
        System.out.println("Libros escritos por "+ a3.nombre+" "+a3.apellido +": " + idA3 );
        System.out.println("Libros escritos por "+ a4.nombre+" "+a4.apellido +": " + idA4 );

        System.out.println("------------------------ ");
        
        
        // Buscar libros por título
        int idL1 = b1.buscarLibroPorTitulo("Cien anios de soledad");
        int idL2 = b1.buscarLibroPorTitulo("Harry Potter y la piedra filosofal");
        int idL3 = b1.buscarLibroPorTitulo("Norwegian Wood");
        int idL4 = b1.buscarLibroPorTitulo("Cronica de una muerte anunciada");
        int idL5 = b1.buscarLibroPorTitulo("Tokio Blues");
        int idL6 = b1.buscarLibroPorTitulo("Mi Libro");
        
         System.out.println("------------------------ ");  
         
         
         // si el id del libro en la lista existe saldra disponible, si no se sabra que esta prestado
         // use (condición ? expresión_verdadera : expresión_falsa) en ves de muchos if-else        
        System.out.println("Libro " + l1.titulo + (idL1 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l2.titulo + (idL2 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l3.titulo + (idL3 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l4.titulo + (idL4 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l5.titulo + (idL5 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l6.titulo + (idL6 >= 0 ? " Disponible" : " Prestado"));
        
        System.out.println("------------------------ ");

        
        // Cantidad de libros en la biblioteca
        int cantidadLibros = b1.cantidadDeLibros();
        System.out.println("Cantidad de libros en la biblioteca: " + cantidadLibros);
        
        System.out.println("------------------------ ");
        System.out.println("LLego mucha gente, algunos libros fueron prestados... ");
        
        
        // Prestar libros a la biblioteca
         b1.prestarLibro(l1);
         b1.prestarLibro(l2);
         b1.prestarLibro(l3);
	 b1.prestarLibro(l6);


         //Buscar libros por autor
        idA1 = b1.buscarLibroPorAutor(a1);
        idA2 = b1.buscarLibroPorAutor(a2);
        idA3 = b1.buscarLibroPorAutor(a3);
        idA4 = b1.buscarLibroPorAutor(a4);

        System.out.println("------------------------ ");


        
        System.out.println("Libros escritos por "+ a1.nombre+" "+a1.apellido +": " + idA1 );
        System.out.println("Libros escritos por "+ a2.nombre+" "+a2.apellido +": " + idA2 );
        System.out.println("Libros escritos por "+ a3.nombre+" "+a3.apellido +": " + idA3 );
        System.out.println("Libros escritos por "+ a4.nombre+" "+a4.apellido +": " + idA4 );

        System.out.println("------------------------ ");

        
        // Buscar libros por título
        idL1 = b1.buscarLibroPorTitulo("Cien anios de soledad");
        idL2 = b1.buscarLibroPorTitulo("Harry Potter y la piedra filosofal");
        idL3 = b1.buscarLibroPorTitulo("Norwegian Wood");
        idL4 = b1.buscarLibroPorTitulo("Cronica de una muerte anunciada");
        idL5 = b1.buscarLibroPorTitulo("Tokio Blues");
        idL6 = b1.buscarLibroPorTitulo("Mi Libro");
         
        System.out.println("------------------------ ");
       

        // si el id del libro en la lista existe saldra disponible, si no se sabra que esta prestado
        // use (condición ? expresión_verdadera : expresión_falsa) en ves de muchos if-else        
        System.out.println("Libro " + l1.titulo + (idL1 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l2.titulo + (idL2 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l3.titulo + (idL3 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l4.titulo + (idL4 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l5.titulo + (idL5 >= 0 ? " Disponible" : " Prestado"));
        System.out.println("Libro " + l6.titulo + (idL6 >= 0 ? " Disponible" : " Prestado"));
        
        System.out.println("------------------------ ");
        

        // Cantidad de libros en la biblioteca
        cantidadLibros = b1.cantidadDeLibros();
        System.out.println("Cantidad de libros en la biblioteca: " + cantidadLibros);
    }
}