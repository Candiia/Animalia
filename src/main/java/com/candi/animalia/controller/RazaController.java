    package com.candi.animalia.controller;

    import com.candi.animalia.dto.raza.GetRazaDTO;
    import com.candi.animalia.model.Raza;
    import com.candi.animalia.service.RazaService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.media.ArraySchema;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.ExampleObject;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import lombok.RequiredArgsConstructor;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.web.PageableDefault;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.UUID;


    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/raza")
    public class RazaController {

        private final RazaService razaService;

        @Operation(summary = "Obtiene todas las razas")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las razas",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetRazaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                            [
                                                {
                                                    "count": 11,
                                                    "items": [
                                                        {
                                                            "nombre": "Podenco"
                                                        },
                                                        {
                                                            "nombre": "Labrador Retriever"
                                                        },
                                                        {
                                                            "nombre": "Siamés"
                                                        },
                                                        {
                                                            "nombre": "Persa"
                                                        },
                                                        {
                                                            "nombre": "Bengalí"
                                                        }
                                                    ]
                                                }
                                            ]
                                        """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna razas",
                content = @Content),
        })
        @GetMapping("/admin")
        public Page<GetRazaDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable){
            Page<Raza> razas = razaService.findAll(pageable);
            return razas.map(GetRazaDTO::of);
        }

        @GetMapping("/{id}")
        public GetRazaDTO findByid(@PathVariable UUID id){
            return GetRazaDTO.of(razaService.findById(id));
        }
    }
