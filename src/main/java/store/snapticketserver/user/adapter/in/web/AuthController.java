package store.snapticketserver.user.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
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

}
