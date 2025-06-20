package store.snapticketserver.user.adapter.in.web.request;

public record SignUpRequest(
        String email,
        String nickname,
        String password
) {
}
