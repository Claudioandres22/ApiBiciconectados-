package Biciconectados.ApiBiciconectados.Service;

import Biciconectados.ApiBiciconectados.Models.Usuario;
import Biciconectados.ApiBiciconectados.Repository.UsuarioRepository;
import Biciconectados.ApiBiciconectados.dto.UsuarioDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
@Transactional

public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }


    @Transactional
    public  UsuarioDTO saveUsuario(UsuarioDTO nuevoUsuario) {

            Usuario usuarioParaGuardar = Usuario.builder()
                    .nombre(nuevoUsuario.getNombreUsuario())
                    .email(nuevoUsuario.getCorreoUsuario())
                    .contrasena(nuevoUsuario.getContrasena())
                    .build();

            usuarioRepository.save(usuarioParaGuardar);
            return nuevoUsuario;
    }

    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }

}