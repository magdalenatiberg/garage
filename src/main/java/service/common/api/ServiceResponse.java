package service.common.api;

import java.util.List;

/**
 * Created by e600783 on 03.07.2016.
 */
public interface ServiceResponse<T> {

    public String getStatus();

    public List<ServiceError> getServiceErrors();

}
