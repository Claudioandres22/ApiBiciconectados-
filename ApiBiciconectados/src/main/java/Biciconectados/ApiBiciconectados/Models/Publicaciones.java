package Biciconectados.ApiBiciconectados.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publicaciones")
@Getter
@Setter
@Builder

public class Publicaciones {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publicacionId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "usuarioId")
    private Usuario usuario;

    private String titulo;

    private String contenido;

    // como lo hacemos para enum???, de repente buscar otra forma de declarar las reacciones
    private String reacciones;

    @CreationTimestamp
    private LocalDateTime fechaPublicacion;
}