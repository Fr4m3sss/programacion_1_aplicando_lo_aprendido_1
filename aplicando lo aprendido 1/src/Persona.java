public class Persona {
    private String nombre;     // Nombre de la persona
    private String apellido;   // Apellido de la persona
    private int edad;          // Edad de la persona
    private String documento;  // Documento de identidad único

    // Constructor con parámetros
    // Inicializa todos los atributos obligatorios de la persona
    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    // Getters y setters con validación

    // Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre inválido");
        } else {
            this.nombre = nombre;
        }
    }

    // Apellido
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        if(apellido == null || apellido.isEmpty()) {
            System.out.println("Apellido inválido");
        } else {
            this.apellido = apellido;
        }
    }

    // Edad
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        // Validación: la edad mínima permitida es 17
        if(edad <= 16) {
            System.out.println("Edad inválida");
        } else {
            this.edad = edad;
        }
    }

    // Documento
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    // Representación en String de la persona
    // Muestra nombre completo, edad y documento
    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento;
    }

    // Equals y hashCode basados en el documento
    // Sirve para comparar objetos Persona según su documento único
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Misma referencia
        if (obj == null || getClass() != obj.getClass()) return false;  // No es Persona
        Persona otra = (Persona) obj;
        return documento != null && documento.equals(otra.documento);
    }

    @Override
    public int hashCode() {
        return documento != null ? documento.hashCode() : 0;
    }
}
