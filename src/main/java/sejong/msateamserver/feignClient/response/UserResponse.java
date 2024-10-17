package sejong.msateamserver.feignClient.response;

public class UserResponse {
	public record GetUserResponse(
		String studentId,
		String name
	) {

	}
}
