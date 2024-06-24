package Biciconectados.ApiBiciconectados.Repository;


import Biciconectados.ApiBiciconectados.Models.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Integer> {
}