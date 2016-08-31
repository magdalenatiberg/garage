package service.getcustomer.business;

import service.common.validation.customer.CustomerId;
import service.getcustomer.business.api.ServiceError;

import javax.validation.constraints.NotNull;

/**
 * Created by Magdalena on 8/27/2016.
 */

public class GetCustomerRequest {
    @CustomerId(message = ServiceError.INVALID_CUSTOMER_ID)
    @NotNull(message = ServiceError.INVALID_CUSTOMER_ID)
    private String customerId;

    public GetCustomerRequest(Builder builder) {
        this.customerId = builder.customerId;
    }

    public GetCustomerRequest () {}

    public String getCustomerId() {
        return customerId;
    }

    public static class Builder {
        private String customerId;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public GetCustomerRequest build() {
            return new GetCustomerRequest(this);
        }
    }
}
