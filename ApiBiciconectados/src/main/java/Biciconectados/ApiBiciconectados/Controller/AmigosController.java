package Biciconectados.ApiBiciconectados.Controller;

import Biciconectados.ApiBiciconectados.Models.AmigosId;
import Biciconectados.ApiBiciconectados.Service.AmigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Biciconectados.ApiBiciconectados.Models.Amigos;
import java.util.List;

@RestController
@RequestMapping("/api/amigos")
public class AmigosController {

    @Autowired
    private AmigosService amigosService;

    @PostMapping("/enviarSolicitud")
    public Amigos enviarSolicitudDeAmistad(@RequestParam Integer usuarioId1, @RequestParam Integer usuarioId2) {
        return amigosService.enviarSolicitudDeAmistad(usuarioId1, usuarioId2);
    }

    @PostMapping("/aceptarSolicitud")
    public Amigos aceptarSolicitudDeAmistad(@RequestBody AmigosId id) {
        return amigosService.aceptarSolicitudDeAmistad(id);
    }

    @PostMapping("/rechazarSolicitud")
    public Amigos rechazarSolicitudDeAmistad(@RequestBody AmigosId id) {
        return amigosService.rechazarSolicitudDeAmistad(id);
    }

    @GetMapping("/obtenerAmigos/{usuarioId}")
    public List<Amigos> obtenerAmigos(@PathVariable Integer usuarioId) {
        return amigosService.obtenerAmigos(usuarioId);
    }
}