package service.createcustomer.business.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by e600783 on 04.07.2016.
 */
public class Address {

	@NotNull(message=ServiceError.INVALID_ADDRESS_STREET)
    @Pattern(regexp="^[a-zA-ZåäöÅÄÖ]{1,50}\\s{1}[a-zA-ZåäöÅÄÖ\\d\\s]{1,60}$", message=ServiceError.INVALID_ADDRESS_STREET)
    private String street;
    @NotNull(message=ServiceError.INVALID_ADDRESS_ZIP_CODE)
    @Pattern(regexp="\\d{5}", message=ServiceError.INVALID_ADDRESS_ZIP_CODE)
    private String zipCode;
    @NotNull(message=ServiceError.INVALID_ADDRESS_CITY)
    @Pattern(regexp="^[a-zA-ZåäöÅÄÖ]{1,50}\\s{0,1}[a-zA-ZåäöÅÄÖ\\s]{0,50}", message=ServiceError.INVALID_ADDRESS_CITY)
    private String city;

    public Address () {}

    public Address(Builder builder) {
        this.street = builder.street;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public static class Builder {
        private String street;
        private String zipCode;
        private String city;


        public Builder () {}

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Address build () {
            return new Address(this);
        }

    }
}
