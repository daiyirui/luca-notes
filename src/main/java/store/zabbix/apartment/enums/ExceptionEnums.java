package store.zabbix.apartment.enums;

public enum ExceptionEnums implements SystemExceptionCode {

    /**
     * 参数为空
     */
    EMPTY_PARAME("A11002", "参数为空"),
    /**
     * 参数错误
     */
    ERROR_PARAME("A11002", "参数错误"),

    PAGE_VAILD("PAGE10001","分页参数错误");

    private String errorCode;
    private String errorMessage;

    ExceptionEnums(String code, String message) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return errorCode;
    }

    public void setCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
