public class Profesor extends Persona {

    public Profesor(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("-------- PROFESOR ---------");
        System.out.println("    Nombre: " + getNombre());
        System.out.println("---------------------------");
    }
}