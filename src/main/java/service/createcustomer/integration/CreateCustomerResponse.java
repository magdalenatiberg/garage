package service.createcustomer.integration;

import service.common.api.ServiceError;

/**
 * Created by E600783 on 15.06.2016.
 */
public class CreateCustomerResponse {

    private ServiceError serviceError;

    public CreateCustomerResponse(Builder builder) {
        this.serviceError = builder.serviceError;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }

    public static class Builder {
        private ServiceError serviceError;

        public Builder serviceError(ServiceError serviceError) {
            this.serviceError = serviceError;
            return this;
        }

        public CreateCustomerResponse build() {
            return new CreateCustomerResponse(this);
        }
    }
}
