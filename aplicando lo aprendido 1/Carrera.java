public class Carrera {
    private String nombre;                    // Nombre de la carrera
    private int cantidadEstudiantes = 0;      // Contador de estudiantes agregados
    private Estudiante[] estudiantes = new Estudiante[10]; // Arreglo de estudiantes

    // Constructor por defecto
    public Carrera() {
        this.nombre = "Sin nombre";
    }

    // Constructor con nombre
    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter de nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Agrega un estudiante a la carrera
    public void agregarEstudiante(Estudiante estudiante) {
        if (cantidadEstudiantes < estudiantes.length) {
            estudiantes[cantidadEstudiantes] = estudiante;
            cantidadEstudiantes++;
        } else {
            System.out.println("No se pueden agregar más estudiantes");
        }
    }

    // Lista todos los estudiantes de la carrera con su promedio
    public void listarEstudiantes() {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println(estudiantes[i].getNombre() + " - Promedio: " + estudiantes[i].getPromedio());
        }
    }

    // Busca un estudiante por nombre (retorna null si no existe)
    public Estudiante buscarEstudiante(String nombre) {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNombre().equals(nombre)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    // Representación en String de la carrera y sus estudiantes
    @Override
    public String toString() {
        String info = "Carrera: " + nombre + " | Cantidad de estudiantes: " + cantidadEstudiantes;
        if (cantidadEstudiantes > 0) {
            info += "\nEstudiantes:";
            for (int i = 0; i < cantidadEstudiantes; i++) {
                info += "\n  - " + estudiantes[i].getNombre() + " | Promedio: " + estudiantes[i].getPromedio();
            }
        }
        return info;
    }
}
