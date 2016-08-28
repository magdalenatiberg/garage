package service.common.validation;

import service.common.api.ServiceError;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by e600783 on 03.07.2016.
 */
public class ValidatorFactory<T> {
    private static Validator validator;

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public List<ServiceError> validate(T reference) {
        javax.validation.ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations =
                validator.validate(reference);

        try {
            List<ServiceError> serviceErrors = new ArrayList<>();
            Iterator iterator = constraintViolations.iterator();
            while(iterator.hasNext()) {
                ConstraintViolation c = (ConstraintViolation) iterator.next();
                String message = c.getMessage();
                serviceErrors.add(new ServiceError.Builder().code(message).message(ServiceError.VALIDATION_ERROR_MESSAGE).build());
            }
            return serviceErrors;
        }
        catch(Exception exception) {

        }
        return null;
    }
}
