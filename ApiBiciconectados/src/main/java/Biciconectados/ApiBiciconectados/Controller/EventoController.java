package Biciconectados.ApiBiciconectados.Controllers;
import Biciconectados.ApiBiciconectados.Models.Evento;
import Biciconectados.ApiBiciconectados.Service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // Endpoint lista de todos eventos
    @GetMapping
    public List<Evento> obtenerTodosEventos() {
        return eventoService.obtenerTodosEventos();
    }

    // Endpoint buscar por id
    @GetMapping("/{id}")
    public Evento obtenerEventoPorId(@PathVariable long id) {
        return eventoService.obtenerEventoPorId(id);
    }

    // Endpoint para crear evento
    @PostMapping
    public void crearEvento(@RequestBody Evento evento) {
        eventoService.crearEvento(evento);
    }

    // Endpoint para actualizar un evento
    @PutMapping("/{id}")
    public void actualizarEvento(
            @PathVariable int id,
            @RequestBody Evento eventoActualizado
    ) {
        eventoService.actualizarEvento(id, eventoActualizado);
    }

    // Endpoint eliminar
    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable long id) {
        eventoService.eliminarEvento(id);
    }
}