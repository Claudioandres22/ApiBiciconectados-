package Biciconectados.ApiBiciconectados.Repository;

import Biciconectados.ApiBiciconectados.Models.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {

}
