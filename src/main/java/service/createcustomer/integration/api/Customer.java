package service.createcustomer.integration.api;

/**
 * Created by E600783 on 05.06.2016.
 */
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;
    private String emailAddress;

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
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
    
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

    public static final class Builder {
        private String customerId;
        private String firstName;
        private String lastName;
        private Address address;
        private String phoneNumber;
        private String emailAddress;

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
        
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
