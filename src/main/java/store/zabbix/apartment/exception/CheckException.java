package store.zabbix.apartment.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import store.zabbix.apartment.enums.SystemExceptionCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private SystemExceptionCode systemExceptionCode;

    private String errorCode;
    private String errorMessage;

    public CheckException(SystemExceptionCode systemExceptionCode) {
        super();
        this.systemExceptionCode = systemExceptionCode;
        this.errorCode = systemExceptionCode.getCode();
        this.errorMessage = systemExceptionCode.getMessage();
    }

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
