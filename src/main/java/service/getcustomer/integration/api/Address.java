package service.getcustomer.integration.api;


/**
 * Created by e600783 on 04.07.2016.
 */
public class Address {

    private String street;
    private String zipCode;
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
