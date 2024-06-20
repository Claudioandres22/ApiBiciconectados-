package Biciconectados.ApiBiciconectados.Controller;


import Biciconectados.ApiBiciconectados.Models.Perfil;
import Biciconectados.ApiBiciconectados.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    private final PerfilService perfilService;

    @Autowired
    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> getAllPerfiles() {
        List<Perfil> perfiles = perfilService.findAllPerfiles();
        return ResponseEntity.ok(perfiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable Long id) {
        Optional<Perfil> perfil = perfilService.findPerfilById(id);
        return perfil.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilService.savePerfil(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPerfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable Long id) {
        perfilService.deletePerfilById(id);
        return ResponseEntity.noContent().build();
    }

























}
