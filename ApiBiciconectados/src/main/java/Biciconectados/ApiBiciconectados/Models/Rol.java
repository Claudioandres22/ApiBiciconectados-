package Biciconectados.ApiBiciconectados.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int id;


    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "nombre_rol")
    private EROL nombreRol;



    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios = new HashSet<>();





}


