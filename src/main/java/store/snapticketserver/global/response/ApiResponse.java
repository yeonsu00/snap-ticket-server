package store.snapticketserver.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import store.snapticketserver.global.response.code.ResponseCode;

@Getter
public class ApiResponse<T> {

    @JsonProperty("code")
    @Schema(description = "응답 코드", example = "SUCCESS")
    private final String code;

    @JsonProperty("message")
    @Schema(description = "응답 메시지", example = "성공입니다.")
    private final String message;

    @Schema(description = "응답 데이터")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private final T data;

    @Builder
    private ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(ResponseCode.OK.getCode())
                .message(ResponseCode.OK.getMessage())
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> failure(ResponseCode code) {
        return ApiResponse.<T>builder()
                .code(code.getCode())
                .message(code.getMessage())
                .data(null)
                .build();
    }
}
