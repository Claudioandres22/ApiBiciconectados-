package Biciconectados.ApiBiciconectados.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RutaDto {

    @NotNull(message = "Este campo debe llenarse")//NotNull
    @Size(min = 2, max = 20)
    private String nombre;

    @NotNull
    private String directionUno;
    @NotNull
    private String directionDos;
    @NotNull
    private int km;

}
