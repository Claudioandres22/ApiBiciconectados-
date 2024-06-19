package Biciconectados.ApiBiciconectados.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="rutas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ruta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int rutaId;

    @ManyToOne
    @JoinColumn("usuarioId")
    private Usuario usuarioId;

    private String nombre;

    private String directionUno;

    private String directionDos;

    private int km;

    @CreationTimestamp
    private LocalDateTime creationDate;

}
