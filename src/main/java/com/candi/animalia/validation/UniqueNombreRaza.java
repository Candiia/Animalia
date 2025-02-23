package com.candi.animalia.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNombreRazaValidator.class)
@Documented
public @interface UniqueNombreRaza {

    String message() default "El nombre de la raza ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
