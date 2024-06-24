package Biciconectados.ApiBiciconectados.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacionControlador {

    @GetMapping("/login")
    public String mostrarPaginaDeLogin(Model model) {
        return "login"; // nombre de la plantilla de la página de inicio de sesión
    }

    @GetMapping("/admin")
    public String mostrarPaginaDeAdmin() {
        return "admin"; // nombre de la plantilla de la página de administración
    }

    @GetMapping("/user")
    public String mostrarPaginaDeUsuario() {
        return "user"; // nombre de la plantilla de la página de usuario
    }

    @GetMapping("/")
    public String mostrarPaginaDeInicio() {
        return "index"; // nombre de la plantilla de la página de inicio
    }
}
