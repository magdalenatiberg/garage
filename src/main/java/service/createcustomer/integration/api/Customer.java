package service.createcustomer.integration.api;

import javax.validation.constraints.NotNull;

/**
 * Created by E600783 on 05.06.2016.
 */
public class Customer {
    @NotNull(message = "")
    private String customerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Address address;

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
    }

    public Customer() {}

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }


    public static final class Builder {
        private String customerId;
        private String firstName;
        private String lastName;
        private Address address;

        public Builder customerId (String customerId) {
            this.customerId = customerId;
            return this;
        }
        public Builder firstName (String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName (String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder address (Address address) {
            this.address = address;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
