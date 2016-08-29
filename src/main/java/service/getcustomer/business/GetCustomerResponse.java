package service.getcustomer.business;

import service.common.api.ServiceError;
import service.common.api.ServiceResponse;
import service.getcustomer.business.api.Customer;

import java.util.List;

/**
 * Created by Magdalena on 8/27/2016.
 */
public class GetCustomerResponse implements ServiceResponse{
    private Customer customer;
    private String status;
    private List<ServiceError> serviceErrors;

    public GetCustomerResponse(Builder builder) {
        this.status = builder.status;
        this.serviceErrors = builder.serviceErrors;
    }
    public String getStatus() {
        return status;
    }

    public List<ServiceError> getServiceErrors() {
        return serviceErrors;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static final class Builder {
        private Customer customer;
        private String status;
        private List<ServiceError> serviceErrors;

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder serviceErrors(List<ServiceError> serviceErrors) {
            this.serviceErrors = serviceErrors;
            return this;
        }

        public GetCustomerResponse build() {
            return new GetCustomerResponse(this);
        }
    }
}
