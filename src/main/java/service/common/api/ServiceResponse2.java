package service.common.api;

import java.util.List;

/**
 * Created by Magdalena on 8/27/2016.
 */
public class ServiceResponse2 {
    private String status;
    private List<ServiceError> serviceErrors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ServiceError> getServiceErrors() {
        return serviceErrors;
    }

    public void setServiceErrors(List<ServiceError> serviceErrors) {
        this.serviceErrors = serviceErrors;
    }
}
