public class Alumno extends Persona {
    private int maxCreditos;
    private int creditosUsados;

    public Alumno(String nombre, int maxCreditos) {
        super(nombre);
        this.maxCreditos = maxCreditos;
        this.creditosUsados = 0;
    }

    public void addCreditos(int creditos) {
        if (creditosUsados + creditos <= maxCreditos) {
            creditosUsados += creditos;
        } else {
            System.out.println("No se pueden aniadir creditos. Se excede el maximo.");
        }
    }

    public void subtractCreditos(int creditos) {
        if (creditosUsados - creditos >= 0) {
            creditosUsados -= creditos;
        } else {
            System.out.println("No se pueden restar creditos. No hay suficientes creditos usados.");
        }
    }

    public int getMaxCreditos() {
        return maxCreditos;
    }

    public int getCreditosUsados() {
        return creditosUsados;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--------- ALUMNO --------");
        System.out.println("  Nombre: " + getNombre());
        System.out.println("  Creditos maximos: " + maxCreditos);
        System.out.println("  Creditos usados: " + creditosUsados);
        System.out.println("-------------------------");
    }
}