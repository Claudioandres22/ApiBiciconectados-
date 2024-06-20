package Biciconectados.ApiBiciconectados.Service;


import Biciconectados.ApiBiciconectados.Models.Perfil;
import Biciconectados.ApiBiciconectados.Repository.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional



public class PerfilService {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public List<Perfil> findAllPerfiles() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> findPerfilById(Long id) {
        return perfilRepository.findById(id);
    }

    public Perfil savePerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public void deletePerfilById(Long id) {
        perfilRepository.deleteById(id);
    }


















}









