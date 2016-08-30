package service.getcustomer.business.api;

/**
 * Created by e600783 on 04.07.2016.
 */
public class ServiceError {

    public static final String INVALID_CUSTOMER_ID = "100";

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
