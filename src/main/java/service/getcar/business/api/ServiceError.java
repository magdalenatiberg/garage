package service.getcar.business.api;


public class ServiceError {
	public static final String INVALID_REGISTRATION_NUMBER = "10";
    public static final String NO_CAR_FOUND = "100";

    public enum Error {
        INVALID_CUSTOMER_ID(ServiceError.INVALID_REGISTRATION_NUMBER);

        private String code;

    /*    INVALID_CUSTOMER_ID("100");
        INVALID_CUSTOMER_ID("100");
        INVALID_CUSTOMER_ID("100"); */

        @SuppressWarnings("unused")
		private String getCode() {
            return code;
        }
        Error(String code) {
            this.code = code;
        }

    }
}
