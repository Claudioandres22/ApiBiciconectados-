package Biciconectados.ApiBiciconectados.Service;

import Biciconectados.ApiBiciconectados.Models.Ruta;
import Biciconectados.ApiBiciconectados.Repository.RutaRepository;
import Biciconectados.ApiBiciconectados.dto.RutaDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;
    //Get
    //Obtiene todas las rutas
    public List<Ruta> getAllRutes() {

        return rutaRepository.findAll() ;
    }
    //Get
    //Obtiene la Ruta por id
    public Ruta getRuteById(int id) {
        return rutaRepository.findById(id).get();
    }
    //Guardar
    public RutaDto saveRoute(RutaDto nuevaRuta) {

        Ruta rutaToSave = Ruta.builder()
                .nombre(nuevaRuta.getNombre())
                .directionUno(nuevaRuta.getDirectionUno())
                .directionDos(nuevaRuta.getDirectionDos())
                .km(nuevaRuta.getKm())
                .build();


        rutaRepository.save(rutaToSave);

        return  nuevaRuta;
    }
    //Actualizar
    public RutaDto editRutaById(RutaDto editRuta,int id){
        Ruta rutaToEdit = rutaRepository.findById(id).get();

        rutaToEdit.setNombre(editRuta.getNombre());
        rutaToEdit.setDirectionUno(editRuta.getDirectionUno());
        rutaToEdit.setDirectionDos(rutaToEdit.getDirectionDos());
        rutaToEdit.setKm(rutaToEdit.getKm());

        rutaRepository.save(rutaToEdit);

        return editRuta;

    }
    //Delete
    public void deleteById(int id){
        rutaRepository.deleteById(id);
    }



}
