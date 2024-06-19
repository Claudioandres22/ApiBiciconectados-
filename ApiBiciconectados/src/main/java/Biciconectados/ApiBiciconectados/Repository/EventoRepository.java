package Biciconectados.ApiBiciconectados.Repository;
import Biciconectados.ApiBiciconectados.Models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}