public class Materia {
    private String nombre;        // Nombre de la materia
    private String codigo;        // Código único de la materia
    private int creditos;         // Cantidad de créditos
    private double calificacion;  // Calificación obtenida por el estudiante
    Profesor profesor;            // Profesor que dicta la materia

    // Constructor con parámetros
    public Materia(String nombre, String codigo, int creditos, double calificacion, Profesor profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
        this.profesor = profesor;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) {
        // Validación de calificación entre 0 y 10
        if(calificacion < 0 || calificacion > 10) {
            System.out.println("Calificación inválida");
        } else {
            this.calificacion = calificacion;
        }
    }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    // Representación en String de la materia, incluyendo profesor
    @Override
    public String toString() {
        return "Materia: " + nombre + " (" + codigo + ")" +
            ", Créditos: " + creditos +
            ", Calificación: " + calificacion +
            ", Profesor: " + profesor.getNombre() + " " + profesor.getApellido();
    }

    // Método equals para comparar materias por su código
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Materia otra = (Materia) obj;
        return codigo != null && codigo.equals(otra.codigo);
    }

    // Hashcode basado en el código de la materia
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
