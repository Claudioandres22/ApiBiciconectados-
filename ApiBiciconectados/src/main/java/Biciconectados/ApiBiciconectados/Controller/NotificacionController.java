package Biciconectados.ApiBiciconectados.Controller;
import Biciconectados.ApiBiciconectados.Models.Notificacion;
import Biciconectados.ApiBiciconectados.Service.NotificacionService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    @Autowired
    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping
    public List<Notificacion> obtenerTodasNotificaciones() {
        return notificacionService.obtenerTodasNotificaciones();
    }

    @GetMapping("/{id}")
    public Notificacion obtenerNotificacionPorId(@PathVariable int id) {
        return notificacionService.obtenerNotificacionPorId(id);
    }

    @PostMapping
    public Notificacion crearNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionService.crearNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizarNotificacion(@PathVariable int id, @RequestBody Notificacion notificacionActualizado) {
        return notificacionService.actualizarNotificacion(id, notificacionActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarNotificacion(@PathVariable int id) {
        notificacionService.eliminarNotificacion(id);
    }
}