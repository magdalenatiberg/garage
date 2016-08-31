package service.common.response;

import java.util.List;

/**
 * Created by e600783 on 03.07.2016.
 */
public interface ServiceResponse {

    public String getStatus();

    public List<ServiceError> getServiceErrors();

}
