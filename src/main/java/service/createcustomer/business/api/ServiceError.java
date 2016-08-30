package service.createcustomer.business.api;

/**
 * Created by e600783 on 04.07.2016.
 */
public class ServiceError {

    public static final String INVALID_CUSTOMER_ID = "10";
    public static final String INVALID_FIRST_NAME = "11";
    public static final String INVALID_LAST_NAME = "12";
    public static final String INVALID_ADDRESS_STREET = "13";
    public static final String INVALID_ADDRESS_ZIP_CODE = "14";
    public static final String INVALID_ADDRESS_CITY = "15";
    public static final String INVALID_ADDRESS = "16";
    public static final String INVALID_PHONE_NUMBER = "17";

    public static final String INVALID_EMAIL_ADDRESS = "18";

    public static final String CUSTOMER_IS_REGISTERED = "100";

    public enum Error {
        INVALID_CUSTOMER_ID(ServiceError.INVALID_CUSTOMER_ID),
        INVALID_FIRST_NAME(ServiceError.INVALID_CUSTOMER_ID),
        INVALID_LAST_NAME(ServiceError.INVALID_LAST_NAME);

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
