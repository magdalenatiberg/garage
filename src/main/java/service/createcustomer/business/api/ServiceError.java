package service.createcustomer.business.api;

/**
 * Created by e600783 on 04.07.2016.
 */
public class ServiceError {

    public static final String INVALID_CUSTOMER_ID = "100";
    public static final String INVALID_FIRST_NAME = "101";
    public static final String INVALID_LAST_NAME = "102";
    public static final String INVALID_ADDRESS_STREET = "103";
    public static final String INVALID_ADDRESS_ZIP_CODE = "104";
    public static final String INVALID_ADDRESS_CITY = "105";
    public static final String CUSTOMER_IS_REGISTERED = "106";

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
