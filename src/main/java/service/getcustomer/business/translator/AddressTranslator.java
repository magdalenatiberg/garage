package service.getcustomer.business.translator;

import org.springframework.stereotype.Component;
import service.getcustomer.business.api.Address;

/**
 * Created by Magdalena on 8/30/2016.
 */
@Component("service.getcustomer.business.api.Address.AddressTranslator")
public class AddressTranslator {

    public Address translate(service.getcustomer.integration.api.Address address) {
        return new Address.Builder()
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .build();
    }
}
