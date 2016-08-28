package service.getcustomer.business.api;

/**
 * Created by Magdalena on 8/27/2016.
 */
public class Customer {

    private String customerId;
    private String firstName;
    private String lastName;

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder {
        private String customerId;
        private String firstName;
        private String lastName;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
