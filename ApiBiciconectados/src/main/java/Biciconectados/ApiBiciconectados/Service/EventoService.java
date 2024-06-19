package Biciconectados.ApiBiciconectados.Service;
import java.util.*;
import Biciconectados.ApiBiciconectados.Models.Evento;
import Biciconectados.ApiBiciconectados.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> obtenerTodosEventos() {
        return eventoRepository.findAll();
    }

    public Evento obtenerEventoPorId(long id) {
        return eventoRepository.findById(id).get();
    }

    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
//arreglar (setId)
    public Evento actualizarEvento(long id, Evento eventoActualizado) {
        eventoActualizado.setId(id);
        return eventoRepository.save(eventoActualizado);
    }


    public void eliminarEvento(long id) {
        eventoRepository.deleteById(id);
    }
}