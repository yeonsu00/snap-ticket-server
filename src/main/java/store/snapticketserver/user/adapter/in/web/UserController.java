package store.snapticketserver.user.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.snapticketserver.global.response.CommonApiResponse;
import store.snapticketserver.user.adapter.in.web.request.EmailCheckRequest;
import store.snapticketserver.user.adapter.in.web.request.SignUpRequest;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(summary = "회원가입", description = "이메일, 비밀번호, 닉네임으로 회원가입을 합니다.")
    @PostMapping("/signup")
    public CommonApiResponse<String> signup(@RequestBody SignUpRequest signUpRequest) {
        return CommonApiResponse.success("회원가입이 완료되었습니다.");
    }

    @Operation(summary = "이메일 중복 확인", description = "이메일 중복 확인을 합니다.")
    @PostMapping("/email")
    public CommonApiResponse<String> checkEmail(@RequestBody EmailCheckRequest emailCheckRequest) {
        return CommonApiResponse.success("사용 가능한 이메일입니다.");
    }
}
