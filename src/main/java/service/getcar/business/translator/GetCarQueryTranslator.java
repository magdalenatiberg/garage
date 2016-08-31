package service.getcar.business.translator;

import org.springframework.stereotype.Component;

@Component
public class GetCarQueryTranslator {

    public String translate(String registrationNumber) {
    	StringBuilder getCarQuery = new StringBuilder();
        getCarQuery.append("select * from car where registration_number = '");
        getCarQuery.append(registrationNumber);
        getCarQuery.append("'");
        return getCarQuery.toString();
    }
}
