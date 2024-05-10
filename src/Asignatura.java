import java.util.HashSet;
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
}