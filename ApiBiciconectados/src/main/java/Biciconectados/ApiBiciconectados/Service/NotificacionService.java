package Biciconectados.ApiBiciconectados.Service;
import java.util.*;
import Biciconectados.ApiBiciconectados.Models.Notificacion;
import Biciconectados.ApiBiciconectados.Repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;


    @Autowired
    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public List<Notificacion> obtenerTodasNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Notificacion obtenerNotificacionPorId(int id) {
        Optional<Notificacion> optionalNotificacion = notificacionRepository.findById(id);
        return optionalNotificacion.orElse(null);
    }

    public Notificacion crearNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizarNotificacion(int id, Notificacion notificacionActualizado) {
        notificacionActualizado.setNotificacionesId(id);
        return notificacionRepository.save(notificacionActualizado);
    }

    public void eliminarNotificacion(int id) {
        notificacionRepository.deleteById(id);
    }
}