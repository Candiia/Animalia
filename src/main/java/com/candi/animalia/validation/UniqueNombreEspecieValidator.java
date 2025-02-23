package com.candi.animalia.validation;

import com.candi.animalia.repository.EspecieRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueNombreEspecieValidator implements ConstraintValidator<UniqueNombreEspecie, String> {

    @Autowired
    private EspecieRepository especieRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !especieRepository.existsByNombre(s);
    }
}
