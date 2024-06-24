package Biciconectados.ApiBiciconectados.Service;


import Biciconectados.ApiBiciconectados.Models.Publicaciones;
import Biciconectados.ApiBiciconectados.Repository.PublicacionesRepository;
import Biciconectados.ApiBiciconectados.dto.PublicacionesDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class PublicacionesService {

    @Autowired
    private PublicacionesRepository publicacionesRepository;

    public List<Publicaciones> getAllPublicaciones() {
        return publicacionesRepository.findAll();
    }

    public Publicaciones getPublicacionesById(int id) {
        return publicacionesRepository.findById(id).get();
    }

    public PublicacionesDTO savePublicacion(PublicacionesDTO publicacion) {

        Publicaciones nuevaPublicacion = Publicaciones.builder()
                //Definir forma de llamar al usuario .usuario()
                .titulo(publicacion.getTitulo())
                .contenido(publicacion.getContenido())
                .build();

        publicacionesRepository.save(nuevaPublicacion);

        return publicacion;
    }

    public PublicacionesDTO editPublicacionesById(PublicacionesDTO editPublicaciones,int id){
        Publicaciones publicacionesToEdit = publicacionesRepository.findById(id).get();

        publicacionesToEdit.setTitulo(editPublicaciones.getTitulo());
        publicacionesToEdit.setContenido(editPublicaciones.getContenido());

        publicacionesRepository.save(publicacionesToEdit);

        return editPublicaciones;

    }

    public PublicacionesDTO reaccionesPublicacionesById(PublicacionesDTO editPublicaciones,int id){
        Publicaciones publicacionesToEdit = publicacionesRepository.findById(id).get();

        //Aquí poner editar reacciones

        publicacionesRepository.save(publicacionesToEdit);

        return editPublicaciones;

    }

    public void deletePublicacionesById(int id) {
        publicacionesRepository.deleteById(id);
    }
}