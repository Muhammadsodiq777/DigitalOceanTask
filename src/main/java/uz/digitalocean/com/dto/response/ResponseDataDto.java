package uz.digitalocean.com.dto.response;

public class ResponseDataDto<T> {

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    public ResponseDataDto() {
    }

    public ResponseDataDto(boolean success) {
        this.success = success;
    }

    public ResponseDataDto(boolean success, Integer code) {
        this.success = success;
        this.code = code;
    }

    public ResponseDataDto(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResponseDataDto(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
