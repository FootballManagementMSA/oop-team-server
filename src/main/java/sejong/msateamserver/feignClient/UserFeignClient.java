package sejong.msateamserver.feignClient;

import static sejong.msateamserver.feignClient.response.UserResponse.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserFeignClient {
	@GetMapping("/api/user-service/users")
	GetUserResponse getUser(@RequestParam("studentId") String studentId);
}
