package sejong.msateamserver.global.exception;

import lombok.Getter;

@Getter
public class FcmTokenNotFoundException extends RuntimeException{
    public FcmTokenNotFoundException(String message) {
        super(message);
    }
}
