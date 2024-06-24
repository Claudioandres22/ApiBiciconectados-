package Biciconectados.ApiBiciconectados.Repository;


import Biciconectados.ApiBiciconectados.Models.AmigosId;
import Biciconectados.ApiBiciconectados.Models.Amigos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmigosRepository extends JpaRepository<Amigos, AmigosId> {
    List<Amigos> findByIdUsuarioId1OrIdUsuarioId2(Integer usuarioId1, Integer usuarioId2);
}