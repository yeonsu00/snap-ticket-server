package store.snapticketserver;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Health Check", description = "Health Check API")
@RestController
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "OK";
    }

}
