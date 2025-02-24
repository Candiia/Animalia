package com.candi.animalia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Column(length = 500)
    private String biografia;

    @Column(length = 650)
    private String avatar;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "raza_id",
            foreignKey = @ForeignKey(name = "fk_mascota_raza")
    )
    private Raza raza;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_mascota_usuario")
    )
    private Usuario usuario;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "especie_id",
            foreignKey = @ForeignKey(name = "fk_mascota_especie")
    )
    private Especie especie;



    @OneToMany(
            mappedBy="mascota",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @Builder.Default
    List<Publicacion> publicacions = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Mascota mascota = (Mascota) o;
        return getId() != null && Objects.equals(getId(), mascota.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }


    public void addPublicacion (Publicacion p){
        p.setMascota(this);
        this.publicacions.add(p);
    }

    public void removePublicacion(Publicacion p){
        this.publicacions.remove(p);
        p.setMascota(null);
    }
}
