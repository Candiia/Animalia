package com.candi.animalia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String image;
    private String descripcion;
    private LocalDate fechaPublicacion;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_publicacion_usuario")
    )
    private Usuario usuario;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "mascota_id",
            foreignKey = @ForeignKey(name = "fk_publicacion_mascota")
    )
    private Mascota mascota;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Publicacion that = (Publicacion) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
