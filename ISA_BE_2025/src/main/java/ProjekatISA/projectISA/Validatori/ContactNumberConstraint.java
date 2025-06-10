package ProjekatISA.projectISA.Validatori;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraint  {
    String message() default "Nevalidan broj telefona.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
