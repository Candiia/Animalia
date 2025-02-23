package com.candi.animalia.validation;

import com.candi.animalia.repository.RazaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueNombreRazaValidator implements ConstraintValidator<UniqueNombreRaza, String> {

    @Autowired
    private RazaRepository razaRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !razaRepository.existsByNombre(s);
    }
}
