package Biciconectados.ApiBiciconectados.Repository;

import Biciconectados.ApiBiciconectados.Models.EROL;
import Biciconectados.ApiBiciconectados.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombreRol(EROL nombreRol);
}