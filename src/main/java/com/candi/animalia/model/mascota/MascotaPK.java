package com.candi.animalia.model.mascota;

import com.candi.animalia.model.Usuario;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MascotaPK implements Serializable {

    private UUID id;
    private Usuario usuario;
}
