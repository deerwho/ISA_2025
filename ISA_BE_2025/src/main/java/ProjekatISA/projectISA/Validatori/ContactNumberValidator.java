package ProjekatISA.projectISA.Validatori;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Annotation;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext context) {
        return contactField !=null && contactField.matches("[0-9]+") && (contactField.length()>8) && (contactField.length()<14);
    }
}
