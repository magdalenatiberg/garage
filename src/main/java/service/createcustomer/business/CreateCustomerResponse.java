package service.createcustomer.business;

import service.common.response.ServiceError;
import service.common.response.ServiceResponse;

import java.util.List;

/**
 * Created by E600783 on 29.06.2016.
 */
public class CreateCustomerResponse implements ServiceResponse {
    private String status;
    private List<ServiceError> serviceErrors;

    public CreateCustomerResponse(Builder builder) {
        this.status = builder.status;
        this.serviceErrors = builder.serviceErrors;
    }
    public String getStatus() {
        return status;
    }

    public List<ServiceError> getServiceErrors() {
        return serviceErrors;
    }

    public static final class Builder {
        private String status;
        private List<ServiceError> serviceErrors;

        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder serviceErrors(List<ServiceError> serviceErrors) {
            this.serviceErrors = serviceErrors;
            return this;
        }

        public CreateCustomerResponse build() {
            return new CreateCustomerResponse(this);
        }
    }
}
