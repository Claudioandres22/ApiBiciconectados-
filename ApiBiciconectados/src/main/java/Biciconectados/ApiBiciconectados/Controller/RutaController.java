package Biciconectados.ApiBiciconectados.Controllers;


import Biciconectados.ApiBiciconectados.Models.Ruta;
import Biciconectados.ApiBiciconectados.Service.RutaService;
import Biciconectados.ApiBiciconectados.dto.RutaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/ruta")
public class RutaController {
    @Autowired
    private RutaService rutaService;
    //Todas las rutas
    @GetMapping("/rutas")
    public List<Ruta> getAllRoutes(){
        return rutaService.getAllRutes();
    }
    //Ruta por id
    @GetMapping("/{id}")
    public Ruta getRutaById(@PathVariable  int id){
        return rutaService.getRuteById(id);
    }
    //Guardar ruta
    @PostMapping("/nuevo")
    public ResponseEntity<?> guardarRuta(@Valid @RequestBody RutaDto nuevaRuta, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("no se pudo guardar verifique los campos", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(rutaService.saveRoute(nuevaRuta),HttpStatus.CREATED);
    }
    //Editar Ruta
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editRoute(@Valid @RequestBody RutaDto rutaToEdit,BindingResult result, int id){
        if (result.hasErrors()){
            return new ResponseEntity<>("Verifica los campos",HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>(rutaService.editRutaById(rutaToEdit,id),HttpStatus.OK);
    }
    //Borrar Ruta
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRoute(@RequestParam int id,BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>("no se pudo borrar",HttpStatus.NOT_ACCEPTABLE);
        }
        rutaService.deleteById(id);
        return new ResponseEntity<>( "Borrado Correctamente",HttpStatus.OK);

    }




}
