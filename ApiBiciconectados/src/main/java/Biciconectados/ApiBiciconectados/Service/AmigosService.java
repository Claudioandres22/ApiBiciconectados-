package Biciconectados.ApiBiciconectados.Service;

import Biciconectados.ApiBiciconectados.Models.Amigos;
import Biciconectados.ApiBiciconectados.Models.AmigosId;
import Biciconectados.ApiBiciconectados.Models.EstadoAmistad;
import Biciconectados.ApiBiciconectados.Repository.AmigosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AmigosService {

    @Autowired
    private AmigosRepository amigosRepository;

    public Amigos enviarSolicitudDeAmistad(Integer usuarioId1, Integer usuarioId2) {
        AmigosId id = new AmigosId(usuarioId1, usuarioId2);
        Amigos solicitud = new Amigos(id, EstadoAmistad.PENDIENTE, LocalDateTime.now());
        return amigosRepository.save(solicitud);
    }

    public Amigos aceptarSolicitudDeAmistad(AmigosId id) {
        Amigos amistad = amigosRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        amistad.setEstado(EstadoAmistad.ACEPTADO);
        return amigosRepository.save(amistad);
    }

    public Amigos rechazarSolicitudDeAmistad(AmigosId id) {
        Amigos amistad = amigosRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        amistad.setEstado(EstadoAmistad.RECHAZADO);
        return amigosRepository.save(amistad);
    }

    public List<Amigos> obtenerAmigos(Integer usuarioId) {
        return amigosRepository.findByIdUsuarioId1OrIdUsuarioId2(usuarioId, usuarioId);
    }
}