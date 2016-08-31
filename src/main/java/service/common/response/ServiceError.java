package service.common.response;

/**
 * Created by E600783 on 15.06.2016.
 */
public class ServiceError {
    public static final String VALIDATION_ERROR_MESSAGE = "Validation error";

    public enum Error {
        GENERAL_ERROR("1000", "General error");

        private String code;
        private String message;

        Error(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
    private String code;
    private String message;

    public ServiceError(Builder builder) {
        this.code = builder.code;
        this.message = builder.message;
    }

    public ServiceError (Error error) {
        this.code = error.code;
        this.message = error.message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final class Builder {
        private String code;
        private String message;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ServiceError build() {
            return new ServiceError(this);
        }
    }
}
