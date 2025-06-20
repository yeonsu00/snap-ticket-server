package store.snapticketserver.user.adapter.in.web.request;

public record LogInRequest(
        String email,
        String password
) {
}
