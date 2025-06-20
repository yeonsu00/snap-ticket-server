package store.snapticketserver.user.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.snapticketserver.global.response.CommonApiResponse;
import store.snapticketserver.user.adapter.in.web.request.LogInRequest;
import store.snapticketserver.user.adapter.in.web.response.LogInResponse;
import store.snapticketserver.user.adapter.in.web.response.ValidateRefreshTokenResponse;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Operation(summary = "로그인", description = "이메일, 비밀번호로 로그인합니다.",
            responses = {
                    @ApiResponse(
                            headers = {
                                    @Header(name = "Set-Cookie", description = "refreshToken", schema = @Schema(type = "string"))
                            }
                    )
            }
    )
    @PostMapping("/login")
    public CommonApiResponse<LogInResponse> login(@RequestBody LogInRequest logInRequest) {
        return CommonApiResponse.success(new LogInResponse("my-access-token"));
    }

    @Operation(summary = "리프레시 토큰 유효성 검사 (로그인 필요)", description = "리프레시 토큰 유효성 검사 성공 시 새로운 액세스 토큰 발급합니다.",
            responses = {
                    @ApiResponse(
                            headers = {
                                    @Header(name = "Set-Cookie", description = "refreshToken", schema = @Schema(type = "string"))
                            }
                    )
            }

    )
    @Parameters({
            @Parameter(
                    name = "Cookie",
                    description = "refreshToken=my-refresh-token",
                    in = ParameterIn.HEADER,
                    required = true
            )
    })
    @PostMapping("/validate")
    public CommonApiResponse<ValidateRefreshTokenResponse> validateRefreshToken() {
        return CommonApiResponse.success(new ValidateRefreshTokenResponse("my-new-access-token"));
    }

}
