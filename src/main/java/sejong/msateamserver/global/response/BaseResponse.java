package sejong.msateamserver.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import sejong.msateamserver.global.response.constant.ResponseMessageConstant;

@Data
@AllArgsConstructor
@Builder
public class BaseResponse {
    private Integer status;
    private String message;
    public BaseResponse(){
        this.message  = ResponseMessageConstant.SUCCESS;
        this.status = 200;
    }
}
