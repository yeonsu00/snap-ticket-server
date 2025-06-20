package store.snapticketserver.user.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.snapticketserver.global.response.ApiResponse;
import store.snapticketserver.user.adapter.in.web.request.SignUpRequest;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(summary = "회원가입", description = "이메일, 비밀번호, 닉네임으로 회원가입을 합니다.")
    @PostMapping("/signup")
    public ApiResponse<String> signup(@RequestBody SignUpRequest signUpRequest) {
        return ApiResponse.success("회원가입이 완료되었습니다.");
    }
}
