import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Asignatura implements Informacion {
    private String nombre;
    private int creditos;
    private Set<Alumno> alumnos;
    private Profesor profesor;

    public Asignatura(String nombre, int creditos, Profesor profesor) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.alumnos = new HashSet<>();
        this.profesor = profesor;
    }

    public void addAlumno(Alumno alumno) {
        int sumaCreditos = alumno.getCreditosUsados() + creditos;
        // Verifica si el estudiante tiene suficientes creditos disponibles
        if (alumno.getCreditosUsados() + creditos <= alumno.getMaxCreditos()) {
            alumnos.add(alumno);
            alumno.addCreditos(creditos);
            System.out.println(alumno.getNombre() + " se aniadio a " + this.nombre + " correctamente.");
        } else {
            System.out.println("*** " + alumno.getNombre() + " no se aniadio a " + this.nombre + ". Ya que excederia su numero maximo de creditos (" + sumaCreditos + " de " + alumno.getMaxCreditos() + ") ***");
        }
    }

    public void deleteAlumno(Alumno alumno) {
        int restaCreditos = alumno.getCreditosUsados() - creditos;
        if (restaCreditos >= 0) {
            alumnos.remove(alumno);
            alumno.subtractCreditos(creditos);
            System.out.println(alumno.getNombre() + " se elimino de " + this.nombre + " correctamente.");
        } else {
            System.out.println("*** " + alumno.getNombre() + " no se pudo eliminar de " + this.nombre + ". Ya que no tiene suficientes creditos para esta asignatura ***");
        }
    }

    public boolean cursaAsignatura(Alumno alumno) {
        if (alumnos.contains(alumno)) {
            System.out.println(alumno.getNombre() + " esta en " + this.nombre);
            return true;
        } else {
            System.out.println(alumno.getNombre() + " no esta en " + this.nombre);
            return false;
        }
    }

    public void mostrarListaDeClase() {
        System.out.println("Los alumnos inscritos son:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre());
        }
    }

    public void quitarTodosLosAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre() + " se elimino de " + this.nombre + " correctamente.");
            alumno.subtractCreditos(creditos);
        }
            alumnos.clear();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("-------- ASIGNATURA -------");
        System.out.println("    Nombre: " + nombre);
        System.out.println("    Profesor: " + profesor.getNombre());
        System.out.println("    Creditos: " + creditos);
        System.out.println("Los alumnos inscritos son: ");
        for (Alumno alumno : alumnos) {
            System.out.println("        - " + alumno.getNombre());
        }
        System.out.println("    Total Alumnos: " + alumnos.size());
        System.out.println("---------------------------");
    }
   
    //TALLER PARTE 2
    
    public void añadirAlumno() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Ingrese el nombre del alumno: ");
        String nombreAlumno = scn.nextLine();
        System.out.print("Ingrese el maximo de creditos para el alumno: ");
        int maxCreditos = scn.nextInt();
        Alumno alumno = new Alumno(nombreAlumno, maxCreditos);
        addAlumno(alumno);
    }

    public void respaldar() throws IOException {
        File salida = new File("alumnos.txt");
        FileWriter escritor = null;
        String linea;
        try {
            escritor = new FileWriter(salida);
            for (Alumno alumno : alumnos) {
            linea = alumno.getNombre() + "," + alumno.getMaxCreditos() + "\n";
            escritor.write(linea);
            }
            System.out.println("Datos de los alumnos respaldados correctamente en el archivo alumnos.txt.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }

    public void cargarAlumnos() throws IOException {
        File entrada = new File("alumnos.txt");
        BufferedReader buffer = null;
        try {
            FileReader lector = new FileReader(entrada);
            buffer = new BufferedReader(lector);
            String linea;

            while ((linea = buffer.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombreAlumno = partes[0];
                    int maxCreditos = Integer.parseInt(partes[1]);
                    Alumno alumno = new Alumno(nombreAlumno, maxCreditos);
                    addAlumno(alumno);
                }
            }
            System.out.println("Alumnos cargados correctamente desde el archivo alumnos.txt.");

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");

        } catch (IOException e) {
            System.out.println("Error al cargar los alumnos");

        } finally {
            if (buffer != null) {
                buffer.close();
            }
        }
    } 
    public void gestion() throws IOException{
        int opt =-1;
        String salida = "./alumnos.txt"; // Nombre del fichero de respaldo
        Scanner scn = new Scanner(System.in);
        
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                  Sistema de gestion de Asignaturas                   |");
        System.out.println("                   "+this.nombre);
        System.out.println("|                                                                      |");
        while (true) {
            try{
                System.out.println("+----------------------------------------------------------------------+");
                System.out.println("Selecione lo que quiere realizar (ingrese el numero):");
                System.out.println("   1- ver Informacion de la asignatura.");
                System.out.println("   2- ver alumnos.");
                System.out.println("   3- ver profesor.");
                System.out.println("   4- aniadir alumno.");
                System.out.println("   5- respaldar alumnos.");
                System.out.println("   6- cargar alumnos.");
                System.out.println("   7- salir.");
                System.out.println("------------------------------------------------------------------------");
                System.out.print(">> ");
                opt = scn.nextInt();
                scn.nextLine(); //<--- PARA QUE NO GENERE PROBLEMAS CON NEXTLINE SIGIENTE
                switch (opt) {
                    case 1:
                        mostrarInfo();
                        break;  
                    case 2:
                        mostrarListaDeClase();
                        break;                    
                    case 3:
                        profesor.mostrarInfo();
                        break; 
                    case 4:
                        añadirAlumno();
                        break; 
                    case 5:
                        respaldar();
                        break;                        
                    case 6:
                        cargarAlumnos();
                        break;
                    case 7:
                        System.out.println("Cerrando el programa.");
                        System.exit(0); 
                        break;                        
                    default:
                        System.out.println("Opcion fuera de rango. Ingrese una opcion valida.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Formato incorrecto, ingrese una opcion valida.");
                scn.next();
            }
        }
    }    
}
