public class Personal extends Persona implements MiembroUniversidad {

    private String fechaIngreso;   // Fecha en que el personal ingresó a la universidad
    private String puesto;         // Puesto o cargo del personal
    private String departamento;   // Departamento al que pertenece

    // Constructor con parámetros
    // Inicializa los atributos heredados de Persona y los específicos de Personal
    public Personal(String nombre, String apellido, int edad, String documento,
                    String fechaIngreso, String puesto, String departamento) {
        super(nombre, apellido, edad, documento);
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.departamento = departamento;
    }

    // Getters y setters
    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    // Representación en String
    // Combina la información de Persona y los datos de Personal
    @Override
    public String toString() {
        return super.toString() + 
            " | Fecha de ingreso: " + fechaIngreso + 
            " | Puesto: " + puesto + 
            " | Departamento: " + departamento;
    }

    // Implementación del método de la interfaz MiembroUniversidad
    // Indica el rol del miembro
    @Override
    public String obtenerRol() {
        return "Rol: Personal";
    }

    // Devuelve toda la información del personal en una sola línea
    @Override
    public String obtenerInformacionCompleta() {
        return getNombre() + " " + getApellido() + " " + getEdad() + " " + getDocumento() + " " + getFechaIngreso() + " " + getPuesto() + " " + getDepartamento();
    }
}
