package service.common.api.validation.customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by e600783 on 04.07.2016.
 */
public class CustomerIdValidator implements ConstraintValidator<CustomerId, String> {

    @Override
    public void initialize(CustomerId constraintAnnotation) {

    }

    public boolean isModulo10(String customerId) {

        int sum = 0;
        for (int i = 0; i < customerId.length(); i++){
            char tmp = customerId.charAt(i);
            int num = tmp - '0';
            int product;
            if (i % 2 != 0){
                product = num * 1;
            }
            else{
                product = num * 2;
            }
            if (product > 9)
                product -= 9;
            sum+= product;
        }
        return (sum % 10 == 0);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }

        if(value.length() != 12) {
            return false;
        }

        String customerId = value.substring(2, 12);
        if(!isModulo10(customerId)) {
            return false;
        }

        return true;
    }
}
