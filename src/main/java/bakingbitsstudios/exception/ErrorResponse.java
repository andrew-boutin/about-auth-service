package bakingbitsstudios.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private final int errorCode;
    private final String errorMsg;
}
