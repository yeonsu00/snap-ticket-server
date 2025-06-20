package store.snapticketserver.global.response.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

    // 성공
    OK(HttpStatus.OK, "SUCCESS", "성공입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ResponseCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

}
