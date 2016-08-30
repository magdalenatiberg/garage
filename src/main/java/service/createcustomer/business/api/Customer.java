package service.createcustomer.business.api;

import service.common.api.validation.customer.CustomerId;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by E600783 on 05.06.2016.
 */
public class Customer {
    private static final String VALID_NAME_REGEP = "([a-zA-ZåäöÅÄÖ\\s]{1,40})";

    @NotNull(message = ServiceError.INVALID_CUSTOMER_ID)
    @CustomerId(message = ServiceError.INVALID_CUSTOMER_ID)
    private String customerId;
    @NotNull
    @Pattern(regexp = VALID_NAME_REGEP, message=ServiceError.INVALID_FIRST_NAME)
    private String firstName;
    @NotNull
    @Pattern(regexp = VALID_NAME_REGEP, message=ServiceError.INVALID_LAST_NAME)
    private String lastName;
    @Valid
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
        public Builder address(Address address) {
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
