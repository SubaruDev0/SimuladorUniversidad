class Taller1 {
    public static void main(String[] args) {     
        System.out.println("TEST DE CREAR ALUMNO\n");
        Alumno a1 = new Alumno("Juan Perez", 10);
        Alumno a2 = new Alumno("Leire Peralta", 10);
        Alumno a3 = new Alumno("Maria Lorente", 10);
        Alumno a4 = new Alumno("Fabio Estrada", 10);
        a1.mostrarInfo();

        System.out.println("TEST DE CREAR PROFESOR\n");
        Profesor p1 = new Profesor("Alan Turing");
        Profesor p2 = new Profesor("Ada Lovelace");
        Profesor p3 = new Profesor("Claude Shannon");
        p1.mostrarInfo();

        System.out.println("TEST DE CREAR ASIGNATURA\n");
        Asignatura asig1 = new Asignatura("Programacion Orientada a Objetos", 4, p1);
        Asignatura asig2 = new Asignatura("Introduccion a la Programacion", 4, p2);
        Asignatura asig3 = new Asignatura("Teoria de la Informacion", 4, p3);
        a1.mostrarInfo();

        System.out.println("TEST DE ANIADIR A ASIGNATURA 1\n");
        a1.mostrarInfo();
        asig1.addAlumno(a1);
        asig1.addAlumno(a2);
        asig1.addAlumno(a3);
        asig1.addAlumno(a4);
        asig1.mostrarInfo();
        a1.mostrarInfo();

        System.out.println("TEST DE ANIADIR A ASIGNATURA 2\n");
        asig2.addAlumno(a1);
        asig3.addAlumno(a1);
        a1.mostrarInfo();

        System.out.println("TEST DE QUITAR DE ASIGNATURA\n");
        a1.mostrarInfo();
        asig1.deleteAlumno(a1);
        asig1.mostrarInfo();
        a1.mostrarInfo();

        System.out.println("TEST DE VERIFICAR ASIGNATURA\n");
        System.out.println(asig1.cursaAsignatura(a2)); 
        asig1.deleteAlumno(a2);
        System.out.println(asig1.cursaAsignatura(a2));

        System.out.println("TEST DE MOSTRAR LISTA\n");
        asig1.mostrarListaDeClase();

        System.out.println("TEST DE QUITAR TODOS LOS ALUMNOS\n");
        a3.mostrarInfo();
        asig1.quitarTodosLosAlumnos();
        asig1.mostrarInfo();
        a3.mostrarInfo();
    }
    
}