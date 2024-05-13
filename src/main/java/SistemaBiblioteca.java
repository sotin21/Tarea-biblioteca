import java.util.ArrayList;
import java.util.List;

class SistemaBiblioteca {
    private List<RecursoDigital> recursosDisponibles;
    private List<Usuario> usuariosRegistrados;
    private List<Prestamo> prestamos;

    public SistemaBiblioteca() {
        recursosDisponibles = new ArrayList<>();
        usuariosRegistrados = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursosDisponibles.add(recurso);
    }

    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
    }

    public void realizarPrestamo(RecursoDigital recurso, Usuario usuario, String fechaPrestamo) {
        Prestamo prestamo = new Prestamo(recurso, usuario, fechaPrestamo);
        prestamos.add(prestamo);
    }

    public void realizarDevolucion(Prestamo prestamo, String fechaDevolucion) {
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamos.remove(prestamo);
    }

    public List<RecursoDigital> buscarPorTitulo(String titulo) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursosDisponibles) {
            if (recurso.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }

    public List<RecursoDigital> buscarPorAutor(String autor) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursosDisponibles) {
            if (recurso.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }

    public List<RecursoDigital> buscarPorAño(int año) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursosDisponibles) {
            if (recurso.getAñoPublicacion() == año) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }

    public List<RecursoDigital> buscarPorClasificacion(String clasificacion) {
        List<RecursoDigital> resultados = new ArrayList<>();
        for (RecursoDigital recurso : recursosDisponibles) {
            if (recurso.getClasificacion().equalsIgnoreCase(clasificacion)) {
                resultados.add(recurso);
            }
        }
        return resultados;
    }

    public void extenderPlazoPrestamo(Prestamo prestamo) {
        // Implementar lógica para extender el plazo de préstamo
        // Por ejemplo, aumentar la fecha de devolución en una cantidad de días
    }

    public List<Prestamo> obtenerPrestamos() {
        return prestamos;
    }
}