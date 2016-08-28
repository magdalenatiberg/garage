package service.createcustomer.business.translator;

import org.springframework.stereotype.Component;
import service.createcustomer.integration.api.Address;

/**
 * Created by e600783 on 04.07.2016.
 */
@Component
public class AddressTranslator {

    public Address translate(service.createcustomer.business.api.Address address) {
        return new Address.Builder()
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .build();
    }

}
