package Biciconectados.ApiBiciconectados.dto;

import Biciconectados.ApiBiciconectados.Models.Usuario;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PublicacionesDTO {

    @NotNull
    private Usuario usuario;

    @NotNull
    @Size(min = 4, max = 100, message = "El título debe contener entre 4 y 100 carácteres")
    private String titulo;

    @NotNull
    @Size(min = 4, max = 250, message = "El cuerpo debe contener entre 4 y 100 carácteres")
    private String contenido;

    //reacciones???

}