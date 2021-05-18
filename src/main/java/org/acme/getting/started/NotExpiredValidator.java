package org.acme.getting.started;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Class NotExpiredValidator: Le da la lógica al @annotation de @NotExpired. Implementa: ConstraintValidator<NombreAnnotationQueCreamos, TipoDatoQueQueremosMeterLógicaOValidar>
 */

public class NotExpiredValidator implements ConstraintValidator<NotExpired, LocalDate> {

    // isValid(), contiene la lógica de la anotación @NotExpired la cual se la daremos nosotros, sus parametros son el tipo de dato a manejar relacionada con al propiedad a la cual va ser aplicada el @NotExpired
    // Y el contexto
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        // Si el valor LocalDate es null, entonces es true porque no contiene valor y no "caduca"
        if (value == null) return true;

        // Tiempo actual, del AHORA
        LocalDate now = LocalDate.now();

        // Compara si el año actual y el año del value "LocalDate" que obtenemos por mediante el parametro es mayor a 0, es decir, que el año del "value" LocalDate debe ser mayor a 0, porque significa que aún le quedan años para expirarse, mientras que si es igual a 0, significa que está cerca del año actual o es igual al año actual. Entre menos años que se acerquen a 0, mñas cerca del año actual y por lo tanto más cerca de expirarse
        return ChronoUnit.YEARS.between(now, value) > 0;
    }
}
