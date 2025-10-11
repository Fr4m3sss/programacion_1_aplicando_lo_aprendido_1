public class Universidad {

    private String nombre;                   // Nombre de la universidad
    private String direccion;                // Dirección física
    private Carrera[] carreras = new Carrera[10];  // Arreglo de carreras disponibles
    private int cantidadCarreras = 0;       // Contador de carreras agregadas

    private MiembroUniversidad[] miembros = new MiembroUniversidad[50]; // Todos los miembros (estudiantes, profesores, personal)
    private int cantidadMiembros = 0;       // Contador de miembros agregados


    // Constructor
    public Universidad(String nombre, String direccion, Carrera[] carreras, int cantidadCarreras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.carreras = carreras;
        this.cantidadCarreras = cantidadCarreras;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Carrera[] getCarreras() { return carreras; }
    public void setCarreras(Carrera[] carreras) { this.carreras = carreras; }

    public int getCantidadCarreras() { return cantidadCarreras; }
    public void setCantidadCarreras(int cantidadCarreras) { this.cantidadCarreras = cantidadCarreras; }


    // Agrega un miembro (Estudiante, Profesor o Personal)
    public void agregarMiembro(MiembroUniversidad miembro) {
        if(cantidadMiembros < miembros.length) {
            miembros[cantidadMiembros] = miembro;
            cantidadMiembros++;
        } else {
            System.out.println("No se pueden agregar más miembros");
        }
    }

    // Lista todos los miembros de la universidad
    public void listarMiembros() {
        for (int i = 0; i < cantidadMiembros; i++) {
            System.out.println(miembros[i].obtenerRol() + " | " + miembros[i].obtenerInformacionCompleta());
        }
    }

    // Busca y muestra miembros según su rol
    public void buscarPorRol(String rol) {
        for (int i = 0; i < cantidadMiembros; i++) {
            if (miembros[i].obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println(miembros[i].obtenerInformacionCompleta());
            }
        }
    }


    // Contar estudiantes de una carrera de forma iterativa
    public int contarEstudiantesIterativo(String carrera) {
        int contador = 0;
        for (int i = 0; i < cantidadMiembros; i++) {
            if (miembros[i] instanceof Estudiante) {
                Estudiante alumno = (Estudiante) miembros[i];
                if (alumno.getCarrera().equalsIgnoreCase(carrera)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    /* Método recursivo para contar estudiantes por carrera (opcional)
    public static int contarEstudiantesRecursivo(MiembroUniversidad[] miembros, String carrera, int indice) {
        if (indice < 0) return 0;
        int suma = 0;
        if (miembros[indice] instanceof Estudiante) {
            Estudiante alumno = (Estudiante) miembros[indice];
            if (alumno.getCarrera().equalsIgnoreCase(carrera)) {
                suma = 1;
            }
        }
        return suma + contarEstudiantesRecursivo(miembros, carrera, indice - 1);
    }
    */

    // Buscar estudiante recursivamente por documento
    public Estudiante buscarEstudianteRecursivo(String documento, int indice) {
        if (indice < 0) return null;

        if (miembros[indice] instanceof Estudiante) {
            Estudiante alumno = (Estudiante) miembros[indice];
            if (alumno.getDocumento().equalsIgnoreCase(documento)) {
                return alumno;
            }
        }
        return buscarEstudianteRecursivo(documento, indice - 1);
    }

    // Mostrar estudiante por documento
    public void mostrarEstudiantePorDocumento(String documento) {
        Estudiante encontrado = buscarEstudianteRecursivo(documento, cantidadMiembros - 1);

        if (encontrado != null) {
            System.out.println("Estudiante encontrado: " 
                + encontrado.getNombre() + " " + encontrado.getApellido() 
                + " | Edad: " + encontrado.getEdad() 
                + " | Carrera: " + encontrado.getCarrera() 
                + " | Promedio: " + encontrado.getPromedio());
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }


    // Ordenamiento de estudiantes por apellido (Selection Sort)
    public static void ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
        int n = estudiantes.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }

            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
    }

    // Búsqueda binaria de estudiantes por apellido
    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        ordenarEstudiantesPorApellido(estudiantes);

        int inicio = 0;
        int fin = estudiantes.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = estudiantes[medio].getApellido().compareToIgnoreCase(apellido);

            if (comparacion == 0) return medio;
            else if (comparacion < 0) inicio = medio + 1;
            else fin = medio - 1;
        }

        return -1;
    }

    // Devuelve un arreglo exacto solo con los estudiantes
    public Estudiante[] obtenerEstudiantes() {
        Estudiante[] temp = new Estudiante[cantidadMiembros];
        int count = 0;
        for (int i = 0; i < cantidadMiembros; i++) {
            if (miembros[i] instanceof Estudiante) {
                temp[count++] = (Estudiante) miembros[i];
            }
        }

        Estudiante[] estudiantes = new Estudiante[count];
        for (int i = 0; i < count; i++) {
            estudiantes[i] = temp[i];
        }
        return estudiantes;
    }


    @Override
    public String toString() {
        String info = "Universidad: " + nombre + " | Dirección: " + direccion;
        info += "\nMiembros:";
        for (int i = 0; i < cantidadMiembros; i++) {
            info += "\n  - " + miembros[i].obtenerRol() + ": " + miembros[i].obtenerInformacionCompleta();
        }
        return info;
    }
}
