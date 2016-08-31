package service.registercar.business.api;


public class ServiceError {
	public static final String INVALID_CUSTOMER_ID = "10";
	public static final String INVALID_CAR = "11";
    public static final String INVALID_REGISTRATION_NUMBER = "12";
    public static final String INVALID_MANUFACTURER = "13";
    public static final String INVALID_MODEL = "14";
	public static final String INVALID_MODEL_YEAR = "15";

	public static final String CAR_ALREADY_REGISTERED = "100";
	public static final String CAR_IS_ALREADY_REGISTERED_ON_CUSTOMER = "101";
	public static final String CUSTOMER_DOES_NOT_EXIST = "102";

    public enum Error {
        INVALID_CUSTOMER_ID(ServiceError.INVALID_CUSTOMER_ID);

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
