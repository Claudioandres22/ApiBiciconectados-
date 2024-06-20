package Biciconectados.ApiBiciconectados.Models;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import java.time.*;

@Entity
@Table(name = "Notificaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificaciones_id")
    private int notificacionesId;

    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "evento_id")
    private int eventId;

    @Column(name = "mensaje_id")
    private int mensajeId;

    @NotNull
    @Column(name = "leído")
    private boolean leído = false;

    @Column(name = "fecha_notificacion")
    private LocalDateTime fechaNotificacion;

}