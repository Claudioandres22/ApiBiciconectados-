package Biciconectados.ApiBiciconectados.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Amigos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Amigos {

    @EmbeddedId
    private AmigosId id;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoAmistad estado;


    @NotNull
    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

}