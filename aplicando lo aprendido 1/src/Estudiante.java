public class Estudiante extends Persona implements MiembroUniversidad {

    private String carrera;               // Carrera que cursa el estudiante
    private double promedio;              // Promedio del estudiante

    private Materia[] materias = new Materia[5];  // Arreglo de materias que cursa
    private int cantidadMaterias = 0;            // Cantidad de materias agregadas

    // Constructor con parámetros
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, double promedio) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.promedio = promedio;
    }

    // Getter y setter de carrera
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) {
        if(carrera == null || carrera.isEmpty()) {
            System.out.println("Carrera inválida");
        } else {
            this.carrera = carrera;
        }
    }

    // Getter y setter de promedio
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) {
        if(promedio < 0 || promedio > 10) {
            System.out.println("Promedio inválido");
        } else {
            this.promedio = promedio;
        }
    }

    // Agregar materia al estudiante
    public void agregarMateria(Materia materia) {
        if (cantidadMaterias >= materias.length) {
            System.out.println("No se pueden agregar más materias");
        } else {
            materias[cantidadMaterias] = materia;
            cantidadMaterias++;
        }
    }

    // Representación en String del estudiante
    @Override
    public String toString() {
        String info = super.toString() + 
                    " | Carrera: " + carrera + 
                    " | Promedio: " + promedio + 
                    " | Materias: ";

        if (cantidadMaterias == 0) {
            info += "No tiene materias asignadas";
        } else {
            for (int i = 0; i < cantidadMaterias; i++) {
                info += "\n    - " + materias[i].getNombre() +
                        " (" + materias[i].getCodigo() + ")" +
                        " | Profesor: " + materias[i].getProfesor().getNombre() + " " +
                        materias[i].getProfesor().getApellido() +
                        " | Calificación: " + materias[i].getCalificacion();
            }
        }
        return info;
    }

    // Implementación de MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Rol: Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return getNombre() + " " + getApellido() + " " + getEdad() + " " + getDocumento() + " " + getCarrera() + " " + getPromedio();
    }

    /*
     * MÉTODOS PARA CALCULAR PROMEDIO
     *
     * Recursivo: Suma las calificaciones de todas las materias usando recursión.
     * Iterativo: Suma las calificaciones usando un bucle for.
     */

    // Método iterativo para calcular promedio
    public double calcularPromedioIterativo() {
        if (cantidadMaterias == 0) return 0;

        double suma = 0;
        for (int i = 0; i < cantidadMaterias; i++) {
            suma += materias[i].getCalificacion();
        }
        return suma / cantidadMaterias;
    }

    // Si quisieras usar recursivo:
    /*
    public static double calcularPromedioRecursivo(Materia[] materias, int indice) {
        if (indice < 0) return 0; // Caso base de la recursión
        return materias[indice].getCalificacion() + calcularPromedioRecursivo(materias, indice - 1);
    }

    public void actualizarPromedioRecursivo() {
        if (cantidadMaterias == 0) {
            promedio = 0;
            return;
        }
        double suma = Estudiante.calcularPromedioRecursivo(this.materias, this.cantidadMaterias - 1);
        promedio = suma / cantidadMaterias;
    }
    */
}
