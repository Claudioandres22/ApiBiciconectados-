package Biciconectados.ApiBiciconectados.Models;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "Eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "evento_id")
    private int eventoId;

    @Column(name = "usuario_id")
    private int usuarioId;

    @NotNull(message = "Este Campo debe llenarse")
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_evento")
    private Date fechaEvento;

    @Column(name = "latitud")
    private String latitud;

    @Column(name = "longitud")
    private String longitud;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;



}