package com.candi.animalia.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNombreEspecieValidator.class)
@Documented
public @interface UniqueNombreEspecie {

    String message() default "El nombre de la especie ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
