package Biciconectados.ApiBiciconectados.Repository;

import Biciconectados.ApiBiciconectados.Models.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}