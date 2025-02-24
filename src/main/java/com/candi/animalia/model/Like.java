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
@Table(name = "likes")
public class Like {

    @EmbeddedId
    private LikePK likePK = new LikePK();


    private LocalDate fechaRealizada;

    @ManyToOne
    @MapsId("publicacionId")
    @JoinColumn(name = "publicacion_id",
            foreignKey = @ForeignKey(name = "fk_like_publicacion"))
    private Publicacion publicacion;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_like_usuario"))
    private Usuario usuario;



    public void addToPublicacion(Publicacion p) {
        p.getLikes().add(this);
        this.publicacion = p;
    }

    public void removeFromPublicacion(Publicacion p) {
        p.getLikes().remove(this);
        this.publicacion = null;
    }

    public void addToUsuario(Usuario u) {
        u.getLikes().add(this);
        this.usuario = u;
    }

    public void removeFromUsuario(Usuario u) {
        u.getLikes().remove(this);
        this.usuario = null;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Like like = (Like) o;
        return getLikePK() != null && Objects.equals(getLikePK(), like.getLikePK());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(likePK);
    }
}
