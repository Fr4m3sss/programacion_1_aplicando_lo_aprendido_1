public class App {
    public static void main(String[] args) {

        Profesor profesor1 = new Profesor("Juan", "Perez", 40, "12345678", "Matemática", 10, 3);
        Profesor profesor2 = new Profesor("Ana", "Gomez", 35, "87654321", "Historia", 8, 2);
        Profesor profesor3 = new Profesor("Luis", "Martinez", 50, "45678912", "Programación", 20, 4);
        
        Estudiante alumno1 = new Estudiante("Juan", "Rodriguez", 23, "42982312","Ingeniería", 0);
        Estudiante alumno2 = new Estudiante("Maria", "Perez", 19, "45352390","Ingeniería", 0);
        Estudiante alumno3 = new Estudiante("Matias", "Gimenez", 21, "43877025","Ingeniería", 0);

        Personal personal1 = new Personal("Laura", "Sanchez", 45, "51234567", "2010-03-15", "Administrativa", "Recursos Humanos");
        Personal personal2 = new Personal("Carlos", "Ramirez", 38, "49876543", "2015-07-22", "Secretario", "Académico");
        Personal personal3 = new Personal("Maria", "Gutierrez", 50, "48765432", "2008-11-10", "Encargada", "Biblioteca");


        Materia materia1 = new Materia("Matemáticas", "MAT101", 4, 8.5, profesor1);
        Materia materia2 = new Materia("Física", "FIS101", 4, 9.0, profesor2);
        Materia materia3 = new Materia("Química", "QUI101", 3, 7.5, profesor3);




        alumno1.agregarMateria(materia1);
        alumno1.agregarMateria(materia2);

        alumno2.agregarMateria(materia2);
        alumno2.agregarMateria(materia3);

        alumno3.agregarMateria(materia1);
        alumno3.agregarMateria(materia3);

        /* para usar la forma recursiva
        alumno1.actualizarPromedioRecursivo();
        alumno2.actualizarPromedioRecursivo();
        alumno3.actualizarPromedioRecursivo();
        */

        alumno1.calcularPromedioIterativo();
        alumno2.calcularPromedioIterativo();
        alumno3.calcularPromedioIterativo();


        Carrera ingenieria = new Carrera();
        

        ingenieria.agregarEstudiante(alumno1);
        ingenieria.agregarEstudiante(alumno2);
        ingenieria.agregarEstudiante(alumno3);



        Carrera[] carrerasIniciales = new Carrera[10];
        int cantidadCarrerasInicial = 0;

        Universidad universidad = new Universidad(
            "Universidad Nacional",
            "Av. Ejemplo 123",
            carrerasIniciales,
            cantidadCarrerasInicial
        );

        universidad.agregarMiembro(alumno1);
        universidad.agregarMiembro(alumno2);
        universidad.agregarMiembro(alumno3);
        universidad.agregarMiembro(profesor1);
        universidad.agregarMiembro(profesor2);
        universidad.agregarMiembro(profesor3);
        universidad.agregarMiembro(personal1);
        universidad.agregarMiembro(personal2);
        universidad.agregarMiembro(personal3);

        universidad.listarMiembros();


        System.out.println("\nEstudiantes:");
        universidad.buscarPorRol("Estudiante");


        System.out.println("\nProfesores:");
        universidad.buscarPorRol("Profesor");


        System.out.println("\nPersonal:");
        universidad.buscarPorRol("Personal");


        Universidad uni = new Universidad("MIT", "Cambridge, MA", new Carrera[10], 0);

        // Agregamos estudiantes con tu constructor real
        uni.agregarMiembro(new Estudiante("Marcos", "Perez", 20, "12345678", "Ing. Info", 9.5));
        uni.agregarMiembro(new Estudiante("Lucia", "Gomez", 21, "87654321", "Derecho", 8.7));

        // Buscamos estudiantes
        uni.mostrarEstudiantePorDocumento("12345678");
        uni.mostrarEstudiantePorDocumento("00000000");


        Estudiante[] estudiantes = universidad.obtenerEstudiantes();

        System.out.println("Antes de ordenar:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getApellido() + ", " + e.getNombre());
        }

        Universidad.ordenarEstudiantesPorApellido(estudiantes);

        System.out.println("\nDespués de ordenar:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getApellido() + ", " + e.getNombre());
        }

        // --- Búsqueda binaria ---
        String apellidoBuscar = "Perez";
        int indice = Universidad.busquedaBinariaEstudiantes(estudiantes, apellidoBuscar);

        System.out.println("\nBúsqueda binaria por apellido: " + apellidoBuscar);
        if (indice != -1) {
            Estudiante encontrado = estudiantes[indice];
            System.out.println("Estudiante encontrado: " 
                + encontrado.getNombre() + " " + encontrado.getApellido() 
                + " | Documento: " + encontrado.getDocumento() 
                + " | Carrera: " + encontrado.getCarrera());
        } else {
            System.out.println("Estudiante no encontrado");
        }
        
    }
}