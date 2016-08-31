package service.registercar.integration.api;

public class ServiceError {
	public static final String CAR_ALREADY_REGISTERED_CODE = "10";
	public static final String CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER_CODE = "11";
	public static final String CUSTOMER_DOES_NOT_EXIST_CODE = "12";
	
	public enum Error {
		CAR_ALREADY_REGISTERED(CAR_ALREADY_REGISTERED_CODE, "The car has already been registered before, customer now registered as co-owner"),
		CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER(CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER_CODE, "Car is already registered on the given customer"),
		CUSTOMER_DOES_NOT_EXIST(CUSTOMER_DOES_NOT_EXIST_CODE, "The given customer was not found in our system and could therfor not be registered as owner");
		private String code;
        private String message;

    /*    INVALID_CUSTOMER_ID("100");
        INVALID_CUSTOMER_ID("100");
        INVALID_CUSTOMER_ID("100"); */

        @SuppressWarnings("unused")
		public String getCode() {
            return code;
        }

        @SuppressWarnings("unused")
		public String getMessage() {
            return message;
        }

        Error(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }
}
