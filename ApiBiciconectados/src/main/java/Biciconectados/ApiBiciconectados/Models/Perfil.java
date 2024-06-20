package Biciconectados.ApiBiciconectados.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Perfiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter





public class Perfil {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfil_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "biografia")
    private String biografia;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "intereses")
    private String intereses;






}
