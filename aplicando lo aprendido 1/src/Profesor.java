public class Profesor extends Persona implements MiembroUniversidad {

    private String especialidad;       // Área de especialización del profesor
    private int añosExperiencia;       // Años de experiencia laboral en su especialidad
    private int materiasAsignadas;     // Cantidad de materias que actualmente dicta

    // Constructor con parámetros
    // Inicializa los atributos heredados de Persona y los propios de Profesor
    public Profesor(String nombre, String apellido, int edad, String documento,
                    String especialidad, int añosExperiencia, int materiasAsignadas) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materiasAsignadas = materiasAsignadas;
    }

    // Getters y setters
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAñosExperiencia() { return añosExperiencia; }
    public void setAñosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }

    public int getMateriasAsignadas() { return materiasAsignadas; }
    public void setMateriasAsignadas(int materiasAsignadas) { this.materiasAsignadas = materiasAsignadas; }

    // Representación en String
    // Combina la información de Persona con los datos específicos del profesor
    @Override
    public String toString() {
        return super.toString() + 
            " | Especialidad: " + especialidad + 
            " | Años de experiencia: " + añosExperiencia + 
            " | Materias asignadas: " + materiasAsignadas;
    }

    // Implementación del método de la interfaz MiembroUniversidad
    // Devuelve el rol del miembro
    @Override
    public String obtenerRol() {
        return "Rol: Profesor";
    }

    // Devuelve toda la información del profesor en una sola línea
    @Override
    public String obtenerInformacionCompleta() {
        return getNombre() + " " + getApellido() + " " + getEdad() + " " + getDocumento() + " " + getEspecialidad() + " " + getAñosExperiencia() + " " + getMateriasAsignadas();
    }
}
