package com.candi.animalia.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;

    @NaturalId
    @Column(unique = true, updatable = false)
    private String username;
    private String password;

    private LocalDate registrationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Builder.Default
    private boolean enabled = false;

    private String activationToken;

    @OneToMany(
            mappedBy="usuario",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @Builder.Default
    List<Mascota> mascotaList = new ArrayList<>();

    @OneToMany(
            mappedBy="usuario",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @Builder.Default
    List<Publicacion> publicacions = new ArrayList<>();

    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    @ToString.Exclude
    private List<Like> likes = new ArrayList<>();

    @Builder.Default
    private Instant createdAt = Instant.now();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    public void addMascota (Mascota m){
        m.setUsuario(this);
        this.mascotaList.add(m);
    }

    public void removeMascota (Mascota m){
        this.mascotaList.remove(m);
        m.setUsuario(null);
    }

    public void addPublicacion (Publicacion p){
        p.setUsuario(this);
        this.publicacions.add(p);
    }

    public void removePublicacion(Publicacion p){
        this.publicacions.remove(p);
        p.setUsuario(null);
    }



}
