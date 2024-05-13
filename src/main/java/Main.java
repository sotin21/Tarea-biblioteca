import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear sistema de biblioteca
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        // Crear recursos digitales
        RecursoDigital libro1 = new RecursoDigital("Todo sobre LAB de prog. II", "John Cena", 2010, "Informática");
        RecursoDigital revista1 = new RecursoDigital("Revista de Mates", "profesor PH", 2021, "Matemáticas");

        // Agregar recursos al sistema
        biblioteca.agregarRecurso(libro1);
        biblioteca.agregarRecurso(revista1);

        // Crear usuarios
        Usuario estudiante1 = new Usuario("Sebastian Soto", "Estudiante");
        Usuario profesor1 = new Usuario("Oscar Aguayo", "Profesor");

        // Registrar usuarios en el sistema
        biblioteca.registrarUsuario(estudiante1);
        biblioteca.registrarUsuario(profesor1);

        // Realizar préstamos
        biblioteca.realizarPrestamo(libro1, estudiante1, "2024-03-12");
        biblioteca.realizarPrestamo(revista1, profesor1, "2023-10-12");

        // Realizar devolución
        List<Prestamo> prestamos = biblioteca.obtenerPrestamos();
        Prestamo prestamoLibro = prestamos.get(0);
        biblioteca.realizarDevolucion(prestamoLibro, "2024-06-19");

        // Realizar búsqueda de recursos
        System.out.println("Recursos encontrados por título:");
        List<RecursoDigital> recursosPorTitulo = biblioteca.buscarPorTitulo("Todo sobre LAB de prog. II");
        for (RecursoDigital recurso : recursosPorTitulo) {
            System.out.println(recurso.getTitulo());
        }

        System.out.println("Recursos encontrados por autor:");
        List<RecursoDigital> recursosPorAutor = biblioteca.buscarPorAutor("profesor PH");
        for (RecursoDigital recurso : recursosPorAutor) {
            System.out.println(recurso.getTitulo());
        }

        System.out.println("Recursos encontrados por año:");
        List<RecursoDigital> recursosPorAño = biblioteca.buscarPorAño(2010);
        for (RecursoDigital recurso : recursosPorAño) {
            System.out.println(recurso.getTitulo());
        }

        System.out.println("Recursos encontrados por clasificación:");
        List<RecursoDigital> recursosPorClasificacion = biblioteca.buscarPorClasificacion("Matemáticas");
        for (RecursoDigital recurso : recursosPorClasificacion) {
            System.out.println(recurso.getTitulo());
        }

        // Extender plazo de préstamo
        biblioteca.extenderPlazoPrestamo(prestamoLibro);

        // Enviar notificaciones
        Notificador notificador = new Notificador();
        notificador.enviarRecordatorioDevolucion(estudiante1);
        notificador.enviarAlertaDisponibilidad(profesor1);
    }
}