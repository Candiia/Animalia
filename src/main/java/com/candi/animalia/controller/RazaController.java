package com.candi.animalia.controller;

import com.candi.animalia.dto.raza.ListRazaDTO;
import com.candi.animalia.service.RazaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raza")
public class RazaController {

    private final RazaService razaService;

    @GetMapping
    public ListRazaDTO findAll(@AuthenticationPrincipal UserDetails userDetails){
        return ListRazaDTO.of(razaService.findAll());
    }
}
