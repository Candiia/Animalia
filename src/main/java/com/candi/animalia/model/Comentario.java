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
public class Comentario {

    @Id
    @GeneratedValue
    private UUID id;
    private String texto;
    private LocalDate fechaRealizada;


    @ManyToOne
    @JoinColumn(name = "publicacion_id",
            foreignKey = @ForeignKey(name = "fk_comentario_publicacion"))
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_comentario_usuario"))
    private Usuario usuario;



    public void addToPublicacion(Publicacion p) {
        p.getComentarios().add(this);
        this.publicacion = p;
    }

    public void removeFromPublicacion(Publicacion p) {
        p.getComentarios().remove(this);
        this.publicacion = null;
    }

    public void addToUsuario(Usuario u) {
        u.getComentarios().add(this);
        this.usuario = u;
    }

    public void removeFromUsuario(Usuario u) {
        u.getComentarios().remove(this);
        this.usuario = null;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Comentario that = (Comentario) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
