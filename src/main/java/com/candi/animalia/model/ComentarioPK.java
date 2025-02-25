package com.candi.animalia.model;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ComentarioPK implements Serializable {

    private UUID publicacionId;

    private UUID usuarioId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ComentarioPK that = (ComentarioPK) o;
        return getPublicacionId() != null && Objects.equals(getPublicacionId(), that.getPublicacionId())
                && getUsuarioId() != null && Objects.equals(getUsuarioId(), that.getUsuarioId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(publicacionId, usuarioId);
    }
}
