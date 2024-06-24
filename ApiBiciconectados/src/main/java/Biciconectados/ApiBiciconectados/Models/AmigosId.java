package Biciconectados.ApiBiciconectados.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AmigosId implements Serializable {

    @Column(name = "usuario_id1")
    private Integer usuarioId1;

    @Column(name = "usuario_id2")
    private Integer usuarioId2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmigosId amigosId = (AmigosId) o;
        return Objects.equals(usuarioId1, amigosId.usuarioId1) && Objects.equals(usuarioId2, amigosId.usuarioId2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId1, usuarioId2);
    }
}