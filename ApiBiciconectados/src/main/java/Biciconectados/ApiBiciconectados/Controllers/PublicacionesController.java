package Biciconectados.ApiBiciconectados.Controllers;

import Biciconectados.ApiBiciconectados.Models.Publicaciones;
import Biciconectados.ApiBiciconectados.Service.PublicacionesService;
import Biciconectados.ApiBiciconectados.dto.PublicacionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/publicacion")
public class PublicacionesController {

    @Autowired
    private PublicacionesService publicacionesService;

    @GetMapping("/todas")
    public List<Publicaciones> getAllPublicaciones(){
        return publicacionesService.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Publicaciones getPublicacionById(@PathVariable int id){
        return publicacionesService.getPublicacionesById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearPublicacion(@RequestBody @Valid PublicacionesDTO nuevaPublicacion, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("No se pudo publicar verifique los campos", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(publicacionesService.savePublicacion(nuevaPublicacion),HttpStatus.CREATED);

    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> editPublicaciones(@Valid @RequestBody PublicacionesDTO publicacionesToEdit,BindingResult result, int id){
        if (result.hasErrors()){
            return new ResponseEntity<>("Verifica los campos",HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>(publicacionesService.editPublicacionesById(publicacionesToEdit,id),HttpStatus.OK);
    }
    @PutMapping("/reacciones/{id}")
    public ResponseEntity<?> editReacciones(@Valid @RequestBody PublicacionesDTO publicacionesToEdit,BindingResult result, int id){
        if (result.hasErrors()){
            return new ResponseEntity<>("Verifica los campos",HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>(publicacionesService.editPublicacionesById(publicacionesToEdit,id),HttpStatus.OK);
    }
    @DeleteMapping("/deletepublicacion")
    public ResponseEntity<?> deletePublicacion(@RequestParam int id, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("No se pudo eliminar",HttpStatus.NOT_ACCEPTABLE);
        }
        publicacionesService.deletePublicacionesById(id);
        return new ResponseEntity<>("Publicación eliminada correctamente", HttpStatus.OK);
    }



    }
