package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePublicacionDTO {

    private String descripcion;
}
