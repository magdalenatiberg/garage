package service.createcustomer.integration;

import service.createcustomer.integration.api.Customer;

/**
 * Created by E600783 on 15.06.2016.
 */
public class CreateCustomerRequest {
    private Customer customer;

    public CreateCustomerRequest(Builder builder) {
        this.customer = builder.customer;
    }

    public CreateCustomerRequest() {}

    public Customer getCustomer() {
        return customer;
    }

    public static final class Builder {
        private Customer customer;

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public CreateCustomerRequest build() {
            return new CreateCustomerRequest(this);
        }
    }
}
