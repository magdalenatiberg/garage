package service.getcustomer.integration;

/**
 * Created by Magdalena on 8/28/2016.
 */
public class GetCustomerRequest {
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
