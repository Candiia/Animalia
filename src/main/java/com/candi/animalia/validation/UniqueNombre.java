package com.candi.animalia.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNombreValidator.class)
@Documented
public @interface UniqueNombre {

    String message() default "El nombre ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
