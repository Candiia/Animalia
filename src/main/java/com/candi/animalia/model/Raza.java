package com.candi.animalia.model;

import com.candi.animalia.model.mascota.Mascota;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;

    @OneToMany(
            mappedBy="raza",
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    List<Mascota> mascotas = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Raza raza = (Raza) o;
        return getId() != null && Objects.equals(getId(), raza.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }


    //helpersMascota
    public void addMascotas (Mascota m){
        m.setRaza(this);
        this.getMascotas().add(m);
    }

    public void removeMascota (Mascota m){
        this.getMascotas().remove(m);
        m.setRaza(null);
    }
}
