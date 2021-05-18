package org.acme.getting.started;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * NotExpired Custom Validator Annotation Class to check if a Beer if expired or not
 */

// @Contraint: Indicarle por cual Validator Class que hemos creado se rige está anotación para determinar si es valido o no.

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NotExpiredValidator.class})
public @interface NotExpired {
    

    // Si la validación falla, lanzamos un mensaje
    String message() default "Beer must not be expired";

    // Nos permite añadir más de un criterio dentro de una validación
    Class<?>[] groups() default { };
    // Información MetaData sobre porque ha fallado este Validator
    Class<? extends Payload>[] payload() default { };

}
